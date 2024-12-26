package io.reflectoring.buckpal.product.adapters.config;

import io.reflectoring.buckpal.product.domain.service.ProductService;
import io.reflectoring.buckpal.product.adapters.output.eventpublisher.ProductEventPublisherAdapter;
import io.reflectoring.buckpal.product.adapters.output.persistence.ProductPersistenceAdapter;
import io.reflectoring.buckpal.product.adapters.output.persistence.mapper.ProductPersistenceMapper;
import io.reflectoring.buckpal.product.adapters.output.persistence.repository.ProductRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductPersistenceAdapter productPersistenceAdapter(ProductRepository productRepository, ProductPersistenceMapper productPersistenceMapper) {
        return new ProductPersistenceAdapter(productRepository, productPersistenceMapper);
    }

    @Bean
    public ProductEventPublisherAdapter productEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new ProductEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public ProductService productService(ProductPersistenceAdapter productPersistenceAdapter, ProductEventPublisherAdapter productEventPublisherAdapter) {
        return new ProductService(productPersistenceAdapter, productEventPublisherAdapter);
    }

}
