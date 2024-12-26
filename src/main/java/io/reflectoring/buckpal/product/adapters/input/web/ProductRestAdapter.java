package io.reflectoring.buckpal.product.adapters.input.web;

import io.reflectoring.buckpal.product.application.ports.in.GetProductUseCase;
import io.reflectoring.buckpal.product.domain.model.Product;
import jakarta.validation.Valid;
import io.reflectoring.buckpal.product.application.ports.in.CreateProductUseCase;
import io.reflectoring.buckpal.product.adapters.input.web.data.request.ProductCreateRequest;
import io.reflectoring.buckpal.product.adapters.input.web.data.response.ProductCreateResponse;
import io.reflectoring.buckpal.product.adapters.input.web.data.response.ProductQueryResponse;
import io.reflectoring.buckpal.product.adapters.input.web.mapper.ProductRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductRestAdapter {

	private final CreateProductUseCase createProductUseCase;

	private final GetProductUseCase getProductUseCase;

	private final ProductRestMapper productRestMapper;

	@PostMapping(value = "/products")
	public ResponseEntity<ProductCreateResponse> createProduct(
			@RequestBody @Valid ProductCreateRequest productCreateRequest) {
		// Request to domain
		Product product = productRestMapper.toProduct(productCreateRequest);

		product = createProductUseCase.createProduct(product);

		// Domain to response
		return new ResponseEntity<>(productRestMapper.toProductCreateResponse(product), HttpStatus.CREATED);
	}

	@GetMapping(value = "/products/{id}")
	public ResponseEntity<ProductQueryResponse> getProduct(@PathVariable Long id) {
		Product product = getProductUseCase.getProductById(id);
		return new ResponseEntity<>(productRestMapper.toProductQueryResponse(product), HttpStatus.OK);
	}

}
