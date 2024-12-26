package io.reflectoring.buckpal.product.adapters.output.eventpublisher;

import io.reflectoring.buckpal.product.application.ports.out.ProductEventPublisher;
import io.reflectoring.buckpal.product.domain.event.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class ProductEventPublisherAdapter implements ProductEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishProductCreatedEvent(ProductCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}
