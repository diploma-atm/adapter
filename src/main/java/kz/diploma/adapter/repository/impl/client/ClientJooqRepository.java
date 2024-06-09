package kz.diploma.adapter.repository.impl.client;

import kz.diploma.adapter.model.entity.response.client.ClientResponse;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kz.diploma.library.shared.jooq.ddl.Tables.CLIENT;

@Repository
@RequiredArgsConstructor
public class ClientJooqRepository {
    private final DSLContext dsl;

    public List<ClientResponse> getAllClients(){
        return dsl
                .select(CLIENT.ID.as("id"))
                .select(CLIENT.SUR_NAME.as("surname"))
                .select(CLIENT.NAME.as("name"))
                .select(CLIENT.LAST_NAME.as("lastName"))
                .select(CLIENT.PHONE_NUMBER.as("phoneNumber"))
                .select(CLIENT.IS_BLOCKED.as("isBlocked"))
                .from(CLIENT)
                .fetchInto(ClientResponse.class);
    }
}
