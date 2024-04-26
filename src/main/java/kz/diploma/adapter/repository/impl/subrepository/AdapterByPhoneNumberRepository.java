package kz.diploma.adapter.repository.impl.subrepository;

import jakarta.persistence.EntityNotFoundException;
import kz.diploma.adapter.model.entity.pojo.ClientPojo;
import kz.diploma.adapter.model.entity.response.ClientResponse;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static kz.diploma.library.shared.jooq.ddl.Tables.CLIENT;

@Repository
public class AdapterByPhoneNumberRepository extends BaseAdapterClientRepository{

    public AdapterByPhoneNumberRepository(DSLContext dsl) {
        super(dsl);
    }

    @Transactional
    public ClientResponse findByPhoneNumber(String phoneNumber) {
        var clientPojo = selectClient()
                .where(CLIENT.PHONE_NUMBER.eq(phoneNumber))
                .fetchOneInto(ClientPojo.class);

        if(clientPojo == null) throw new EntityNotFoundException("Product with this phone number not found");

        return getClientResponse(clientPojo);
    }
}
