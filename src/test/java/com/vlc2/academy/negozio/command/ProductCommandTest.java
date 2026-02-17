package com.vlc2.academy.negozio.command;

import com.vlc2.academy.negozio.dto.product.ProductCreateDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.dto.product.ProductUpdateDTO;
import com.vlc2.academy.negozio.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductCommandTest {

    @Mock
    ProductService productService;

    @InjectMocks
    ProductCreateCommand commandC;

    @InjectMocks
    ProductUpdateCommand commandU;

    ProductReadDTO readDto = new ProductReadDTO(1,"a",1.1);


    @Test
    void executeValidC() {
        when(productService.createProduct(any())).thenReturn(readDto);
        ProductCreateDTO dto = new ProductCreateDTO("a", 1.3, 50);
        commandC.setProductCreateDTO(dto);
        Assertions.assertEquals(commandC.execute(),readDto);
    }

    @Test
    void executeNullC() {
        ProductCreateDTO dto = new ProductCreateDTO("a", null, 50);
        commandC.setProductCreateDTO(dto);
        Assertions.assertThrows(NullPointerException.class , () -> commandC.execute());
    }

    @Test
    void executeInvalidC() {
        ProductCreateDTO dto = new ProductCreateDTO("a", 3.7, 0);
        commandC.setProductCreateDTO(dto);
        Assertions.assertThrows(IllegalArgumentException.class , () -> commandC.execute());
    }

    @Test
    void executeValidU() {
        when(productService.updateProduct(any())).thenReturn(readDto);
        ProductUpdateDTO dto = new ProductUpdateDTO(1, 4);
        commandU.setProductUpdateDTO(dto);
        Assertions.assertEquals(commandU.execute(),readDto);
    }

    @Test
    void executeNullU() {
        ProductUpdateDTO dto = new ProductUpdateDTO(1, null);
        commandU.setProductUpdateDTO(dto);
        Assertions.assertThrows(NullPointerException.class , () -> commandU.execute());
    }

    @Test
    void executeInvalidU() {
        ProductUpdateDTO dto = new ProductUpdateDTO(1, -50);
        commandU.setProductUpdateDTO(dto);
        Assertions.assertThrows(IllegalArgumentException.class , () -> commandU.execute());
    }
}