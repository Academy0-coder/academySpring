package com.vlc2.academy.negozio.dto.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ProductCreateDTO {

    private final String name;
    private final Double price;
    private final Integer quantityInStock;

}
