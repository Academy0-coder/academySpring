package com.vlc2.academy.negozio.mapper;

import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductReadDTO toDTO (Product product){

        return new ProductReadDTO(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getQuantitySold());
    }
}
