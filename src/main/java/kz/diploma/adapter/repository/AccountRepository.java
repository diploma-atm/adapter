package kz.diploma.adapter.repository;

import kz.diploma.adapter.model.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    @Query(value = """
        SELECT a FROM AccountEntity a
        WHERE a.accountNumber = :accountNumber
    """)
    Optional<AccountEntity> findByAccountNumber(@Param("accountNumber")String generatedCardNumber);
}
