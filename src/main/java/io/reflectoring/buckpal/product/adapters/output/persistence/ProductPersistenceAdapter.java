package io.reflectoring.buckpal.product.adapters.output.persistence;

import io.reflectoring.buckpal.product.application.ports.out.ProductOutputPort;
import io.reflectoring.buckpal.product.domain.model.Product;
import io.reflectoring.buckpal.product.adapters.output.persistence.entity.ProductEntity;
import io.reflectoring.buckpal.product.adapters.output.persistence.mapper.ProductPersistenceMapper;
import io.reflectoring.buckpal.product.adapters.output.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
//repository class(PersistenceAdapter)
public class ProductPersistenceAdapter implements ProductOutputPort {

    private final ProductRepository productRepository;

    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Product saveProduct(Product product) {
    	//mapping product to productEntity
        ProductEntity productEntity = productPersistenceMapper.toProductEntity(product);
        productEntity = productRepository.save(productEntity);
        return productPersistenceMapper.toProduct(productEntity);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);

        if(productEntity.isEmpty()) {
            return Optional.empty();
        }

        Product product = productPersistenceMapper.toProduct(productEntity.get());
        return Optional.of(product);
    }

}
