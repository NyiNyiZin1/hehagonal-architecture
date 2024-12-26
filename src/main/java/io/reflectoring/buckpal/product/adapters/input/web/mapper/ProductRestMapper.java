package io.reflectoring.buckpal.product.adapters.input.web.mapper;

import io.reflectoring.buckpal.product.domain.model.Product;
import io.reflectoring.buckpal.product.adapters.input.web.data.response.ProductQueryResponse;
import io.reflectoring.buckpal.product.adapters.input.web.data.request.ProductCreateRequest;
import io.reflectoring.buckpal.product.adapters.input.web.data.response.ProductCreateResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ProductRestMapper {

    Product toProduct(ProductCreateRequest productCreateRequest);

    ProductCreateResponse toProductCreateResponse(Product product);

    ProductQueryResponse toProductQueryResponse(Product product);

}