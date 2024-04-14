package kz.diploma.adapter.repository;

import kz.diploma.adapter.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Query(value = """
      SELECT p FROM ProductEntity p
        WHERE p.pan = :pan
      """)
    Optional<ProductEntity> findByPan(@Param("pan")String pan);
}
