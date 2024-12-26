package io.reflectoring.buckpal.product.domain.service;

import io.reflectoring.buckpal.product.application.ports.in.CreateProductUseCase;
import io.reflectoring.buckpal.product.application.ports.in.GetProductUseCase;
import io.reflectoring.buckpal.product.application.ports.out.ProductEventPublisher;
import io.reflectoring.buckpal.product.application.ports.out.ProductOutputPort;
import io.reflectoring.buckpal.product.domain.event.ProductCreatedEvent;
import io.reflectoring.buckpal.product.domain.exception.ProductNotFound;
import io.reflectoring.buckpal.product.domain.model.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductService implements CreateProductUseCase, GetProductUseCase {

    private final ProductOutputPort productOutputPort;

    private final ProductEventPublisher productEventPublisher;

    @Override
    public Product createProduct(Product product) {
        product = productOutputPort.saveProduct(product);
        productEventPublisher.publishProductCreatedEvent(new ProductCreatedEvent(product.getId()));
        return product;
    }

    @Override
    public Product getProductById(Long id) {
        return productOutputPort.getProductById(id).orElseThrow(() -> new ProductNotFound("Product not found with id " + id));
    }

}
