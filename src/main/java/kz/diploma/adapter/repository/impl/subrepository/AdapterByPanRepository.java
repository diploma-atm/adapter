package kz.diploma.adapter.repository.impl.subrepository;

import jakarta.persistence.EntityNotFoundException;
import kz.diploma.adapter.model.entity.pojo.ProductPojo;
import kz.diploma.adapter.model.entity.response.client.ClientClientResponse;

import kz.diploma.adapter.model.entity.response.product.ProductProductResponse;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static kz.diploma.library.shared.jooq.ddl.Tables.PRODUCT;

@Repository
public class AdapterByPanRepository extends BaseAdapterClientRepository{

    public AdapterByPanRepository(DSLContext dsl) {
        super(dsl);
    }

    @Transactional
    public ClientClientResponse getClientByPan(String pan) {
        var clientId = findClientIdByPan(pan);

        if(clientId == null) throw new EntityNotFoundException("Product with this pan not found");

        var clientPojo = findClientById(clientId);

        return getClientResponse(clientPojo);
    }

    @Transactional
    public ProductProductResponse getProductByPan(String pan) {
        var product = selectProducts().where(PRODUCT.PAN.eq(pan)).fetchOneInto(ProductPojo.class);

        return getProductResponse(product);
    }
}
