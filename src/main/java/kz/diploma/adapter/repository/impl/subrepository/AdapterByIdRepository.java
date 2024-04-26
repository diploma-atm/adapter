package kz.diploma.adapter.repository.impl.subrepository;

import jakarta.persistence.EntityNotFoundException;
import kz.diploma.adapter.model.entity.pojo.ClientPojo;
import kz.diploma.adapter.model.entity.response.ClientResponse;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import static kz.diploma.library.shared.jooq.ddl.Tables.CLIENT;

@Repository
public class AdapterByIdRepository extends BaseAdapterClientRepository{

    public AdapterByIdRepository(DSLContext dsl) {
        super(dsl);
    }

    @Transactional
    public ClientResponse getClientById(Integer id){
        var clientPojo = selectClient()
                .where(CLIENT.ID.eq(id))
                .fetchOneInto(ClientPojo.class);

        if(clientPojo == null) throw new EntityNotFoundException("Client with this id not found");

        return getClientResponse(clientPojo);
    }
}
