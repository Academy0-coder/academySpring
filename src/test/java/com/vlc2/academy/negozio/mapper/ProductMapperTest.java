package com.vlc2.academy.negozio.mapper;

import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductMapperTest {

    ProductMapper mapper = new ProductMapper();

    Product prod1 = new Product("Bistecche",1.11,5);
    Product prod2 = new Product("Salmoni",2.22,6);

    @Test
    void toDTO() {
        ProductReadDTO productDTO = new ProductReadDTO(4,"Bistecche",1.11,5,2);
        ProductReadDTO check = mapper.toDTO(prod1);
        Assertions.assertTrue(productDTO.equals(check));
    }

    @Test
    void listToDto() {
        List<Product> prodS = List.of(prod1,prod2);
        List<ProductReadDTO> prodDTO = List.of(new ProductReadDTO(4,"Bistecche",1.11,5,2),
                new ProductReadDTO(8,"Salmoni", 2.22,6,0));
        List<ProductReadDTO> check = mapper.toDTO(prodS);
        boolean equality = prodDTO.size()==check.size();
        for(int i = 0; i< prodDTO.size(); i++){
            equality = equality && (prodDTO.get(i).equals(check.get(i)));
        }
        Assertions.assertTrue(equality);
    }


}