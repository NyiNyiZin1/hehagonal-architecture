package io.reflectoring.buckpal.product.adapters.input.web.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateResponse {

    private Long id;

    private String name;

    private String description;

}
