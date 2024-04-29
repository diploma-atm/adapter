package kz.diploma.adapter.repository.impl.subrepository;

import jakarta.persistence.EntityNotFoundException;
import kz.diploma.adapter.model.entity.pojo.ClientPojo;
import kz.diploma.adapter.model.entity.pojo.ProductPojo;
import kz.diploma.adapter.model.entity.response.client.ClientClientResponse;
import kz.diploma.adapter.model.entity.response.product.ProductProductResponse;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import static kz.diploma.library.shared.jooq.ddl.Tables.CLIENT;
import static kz.diploma.library.shared.jooq.ddl.Tables.PRODUCT;

@Repository
public class AdapterByIdRepository extends BaseAdapterClientRepository{

    public AdapterByIdRepository(DSLContext dsl) {
        super(dsl);
    }

    @Transactional
    public ClientClientResponse getClientById(Integer id){
        var clientPojo = selectClient()
                .where(CLIENT.ID.eq(id))
                .fetchOneInto(ClientPojo.class);

        if(clientPojo == null) throw new EntityNotFoundException("Client with this id not found");

        return getClientResponse(clientPojo);
    }

    @Transactional
    public ProductProductResponse getProductById(Integer id){
        var productPojo = selectProducts()
                .where(PRODUCT.ID.eq(id))
                .fetchOneInto(ProductPojo.class);

        if(productPojo == null) throw new EntityNotFoundException("Product with this id not found");

        return getProductResponse(productPojo);
    }

}
