package io.reflectoring.buckpal.product.adapters.output.persistence.repository;

import io.reflectoring.buckpal.product.adapters.output.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
