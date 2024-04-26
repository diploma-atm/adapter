package kz.diploma.adapter.repository.impl.subrepository;

import jakarta.persistence.EntityNotFoundException;
import kz.diploma.adapter.model.entity.pojo.ClientPojo;
import kz.diploma.adapter.model.entity.response.ClientResponse;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static kz.diploma.library.shared.jooq.ddl.Tables.CLIENT;

@Repository
public class AdapterByFioRepository extends BaseAdapterClientRepository{

    public AdapterByFioRepository(DSLContext dsl) {
        super(dsl);
    }

    @Transactional
    public List<ClientResponse> getClientByFio(String surname, String name, String lastname) {
        var condition = DSL.condition(CLIENT.SUR_NAME.eq(surname))
                .and(CLIENT.NAME.eq(name));
        if(Objects.nonNull(lastname)){
            condition = condition.and(CLIENT.LAST_NAME.eq(lastname));
        }

        var clientPojo = selectClient()
                .where(condition)
                .fetchInto(ClientPojo.class);

        if(clientPojo.isEmpty()){
            throw new EntityNotFoundException("Client with this fio not found");
        }

        return clientPojo.stream().map(this::getClientResponse).toList();
    }
}
