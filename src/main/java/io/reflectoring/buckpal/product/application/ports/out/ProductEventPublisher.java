package io.reflectoring.buckpal.product.application.ports.out;

import io.reflectoring.buckpal.product.domain.event.ProductCreatedEvent;

public interface ProductEventPublisher {

    void publishProductCreatedEvent(ProductCreatedEvent event);

}
