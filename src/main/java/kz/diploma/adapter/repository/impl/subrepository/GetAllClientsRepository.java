package kz.diploma.adapter.repository.impl.subrepository;

import jakarta.persistence.EntityNotFoundException;
import kz.diploma.adapter.model.entity.pojo.ClientPojo;
import kz.diploma.adapter.model.entity.response.client.ClientClientResponse;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GetAllClientsRepository extends BaseAdapterClientRepository{

    public GetAllClientsRepository(DSLContext dsl) {
        super(dsl);
    }

    @Transactional(readOnly = true)
    public List<ClientClientResponse> getAllClientsResponse(){
        var clientPojo = selectClient().fetchInto(ClientPojo.class);

        if(clientPojo.isEmpty()){
            throw new EntityNotFoundException("Client with this fio not found");
        }

        return clientPojo.stream().map(this::getClientResponse).toList();
    }
}
