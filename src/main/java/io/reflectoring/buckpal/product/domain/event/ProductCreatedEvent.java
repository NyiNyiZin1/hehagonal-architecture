package io.reflectoring.buckpal.product.domain.event;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreatedEvent {

    private Long id;

    private LocalDateTime date;

    public ProductCreatedEvent(Long id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }

}

