package kz.diploma.adapter.repository.impl.subrepository;

import jakarta.persistence.EntityNotFoundException;
import kz.diploma.adapter.model.entity.response.client.ClientClientResponse;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AdapterByPanRepository extends BaseAdapterClientRepository{

    public AdapterByPanRepository(DSLContext dsl) {
        super(dsl);
    }

    @Transactional
    public ClientClientResponse findByPan(String pan) {
        var clientId = findClientIdByPan(pan);

        if(clientId == null) throw new EntityNotFoundException("Product with this pan not found");

        var clientPojo = findClientById(clientId);

        return getClientResponse(clientPojo);
    }

}
