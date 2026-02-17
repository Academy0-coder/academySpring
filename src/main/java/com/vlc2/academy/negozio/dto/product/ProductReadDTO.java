package com.vlc2.academy.negozio.dto.product;

import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
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

    public boolean equals(ProductReadDTO check){
        return getName().equals(check.getName())&&
                getPrice().equals(check.getPrice())&&
                getQuantityInStock().equals(check.getQuantityInStock());
    }
}
