package kz.diploma.adapter.repository.impl.subrepository;

import jakarta.persistence.EntityNotFoundException;
import kz.diploma.adapter.model.entity.response.ClientResponse;

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
    public ClientResponse findByPan(String pan) {
        var clientId = findProduct(pan);

        if(clientId == null) throw new EntityNotFoundException("Product with this pan not found");

        var clientPojo = findClientById(clientId);

        return getClientResponse(clientPojo);
    }

    private Integer findProduct(String pan){
        return this.dsl
                .select(PRODUCT.CLIENT_ID)
                .from(PRODUCT)
                .where(PRODUCT.PAN.eq(pan))
                .fetchOneInto(Integer.class);
    }
}
