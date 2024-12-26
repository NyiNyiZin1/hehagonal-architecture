package io.reflectoring.buckpal.product.adapters.output.persistence.mapper;

import io.reflectoring.buckpal.product.domain.model.Product;
import io.reflectoring.buckpal.product.adapters.output.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductPersistenceMapper {

    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);

}
