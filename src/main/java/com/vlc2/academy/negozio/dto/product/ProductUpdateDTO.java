package com.vlc2.academy.negozio.dto.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ProductUpdateDTO {

    private final Integer id;
    private final Integer quantity;
}
