package io.reflectoring.buckpal.product.application.ports.in;

import io.reflectoring.buckpal.product.domain.model.Product;

public interface GetProductUseCase {

    Product getProductById(Long id);

}
