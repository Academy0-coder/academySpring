package com.vlc2.academy.negozio.dto.product;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ProductReadDTO {

    private final Integer id;
    private final String name;
    private final Double price;
    private Integer quantityInStock;
    private Integer quantitySold;

}
