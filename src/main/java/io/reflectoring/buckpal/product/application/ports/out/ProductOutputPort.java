package io.reflectoring.buckpal.product.application.ports.out;

import io.reflectoring.buckpal.product.domain.model.Product;

import java.util.Optional;

public interface ProductOutputPort {

    Product saveProduct(Product product);

    Optional<Product> getProductById(Long id);

}
