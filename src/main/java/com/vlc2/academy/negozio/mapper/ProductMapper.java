package com.vlc2.academy.negozio.mapper;

import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.entity.Customer;
import com.vlc2.academy.negozio.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    public ProductReadDTO toDTO (Product product){

        return new ProductReadDTO(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getQuantitySold());
    }

    public List<ProductReadDTO> toDTO(List<Product> products){

        return products.stream()
                .map(product -> toDTO(product))
                .toList();

    }
}
