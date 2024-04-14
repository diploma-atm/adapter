package kz.diploma.adapter.repository;

import kz.diploma.adapter.model.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    @Query(value = """
        SELECT c FROM ClientEntity c 
        WHERE c.surname = :surname AND 
            c.name = :name AND 
            c.lastName = :lastname
    """)
    public List<ClientEntity> findClientByFio(@Param("surname")String surname, @Param("name")String name, @Param("lastname")String lastname);

    @Query(value = """
        SELECT c from ClientEntity c
        WHERE c.phoneNumber = :phoneNumber
    """)
    public Optional<ClientEntity> findClientByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
