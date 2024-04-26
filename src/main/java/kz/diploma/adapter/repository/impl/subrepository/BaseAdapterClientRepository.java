package kz.diploma.adapter.repository.impl.subrepository;

import kz.diploma.adapter.model.entity.pojo.ClientPojo;
import kz.diploma.adapter.model.entity.pojo.ProductPojo;
import kz.diploma.adapter.model.entity.response.AccountResponse;
import kz.diploma.adapter.model.entity.response.ClientResponse;
import kz.diploma.adapter.model.entity.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectJoinStep;

import static kz.diploma.library.shared.jooq.ddl.Tables.*;

@RequiredArgsConstructor
public abstract class BaseAdapterClientRepository {
    protected final DSLContext dsl;

    protected SelectJoinStep<Record> selectClient(){
        return dsl
                .select(CLIENT.ID.as("id"))
                .select(CLIENT.SUR_NAME.as("surname"))
                .select(CLIENT.NAME.as("name"))
                .select(CLIENT.LAST_NAME.as("lastName"))
                .select(CLIENT.PHONE_NUMBER.as("phoneNumber"))
                .select(CLIENT.IS_BLOCKED.as("isBlocked"))
                .from(CLIENT);
    }

    protected SelectJoinStep<Record> selectProducts(){
        return dsl
                .select(PRODUCT.ID)
                .select(PRODUCT.CREATED_AT)
                .select(PRODUCT.PAN)
                .select(PRODUCT.PIN)
                .select(PRODUCT.CVV)
                .select(PRODUCT.RBS)
                .select(PRODUCT.ACTIVE)
                .select(PRODUCT.IN_ACCESS)
                .select(PRODUCT.OUT_ACCESS)
                .select(PRODUCT.IS_BLOCKED)
                .from(PRODUCT);
    }

    protected AccountResponse selectAccountByProductId(Integer productId){
        return dsl
                .select(ACCOUNT.ID)
                .select(ACCOUNT.ACCOUNT_NUMBER)
                .select(ACCOUNT.AMOUNT)
                .from(ACCOUNT.as("account"))
                .where(ACCOUNT.PRODUCT_ID.eq(productId))
                .fetchOneInto(AccountResponse.class);
    }

    protected ClientPojo findClientById(Integer clientId){
        return selectClient()
                .where(CLIENT.ID.eq(clientId))
                .fetchOneInto(ClientPojo.class);
    }

    protected ClientResponse getClientResponse(ClientPojo clientPojo){
        var clientResponse = new ClientResponse(clientPojo);

        var productsPojoList = selectProducts().where(PRODUCT.CLIENT_ID.eq(clientPojo.id)).fetchInto(ProductPojo.class);

        clientResponse.products = productsPojoList.stream().map(item1 -> {
            var product = new ProductResponse(item1);
            product.accountResponse = selectAccountByProductId(product.id);

            return product;
        }).toList();

        return clientResponse;
    }
}
