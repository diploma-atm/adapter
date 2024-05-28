package kz.diploma.adapter.repository.impl.admin;

import kz.diploma.adapter.model.entity.response.admin.AdminResponse;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectJoinStep;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kz.diploma.library.shared.jooq.ddl.Tables.ADMIN;

@Repository
@RequiredArgsConstructor
public class AdminJooqRepository {
    private final DSLContext dsl;

    public List<AdminResponse> getAll(){
        return getSql().fetchInto(AdminResponse.class);
    }

    public AdminResponse getById(Integer id){
        return getSql()
                .where(ADMIN.ID.eq(id))
                .fetchOneInto(AdminResponse.class);
    }

    private SelectJoinStep<Record> getSql(){
        return dsl
                .select(ADMIN.ID.as("id"))
                .select(ADMIN.SUR_NAME.as("surname"))
                .select(ADMIN.NAME.as("name"))
                .select(ADMIN.LAST_NAME.as("lastname"))
                .select(ADMIN.PHONE_NUMBER.as("phoneNumber"))
                .select(ADMIN.POST.as("post"))
                .select(ADMIN.REGISTRATION.as("registration"))
                .from(ADMIN);
    }
}
