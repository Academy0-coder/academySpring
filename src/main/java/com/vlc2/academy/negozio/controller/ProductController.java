package com.vlc2.academy.negozio.controller;

import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.dto.product.ProductCreateDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.dto.product.ProductUpdateDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController {

    ResponseEntity<ProductReadDTO> createProduct(ProductCreateDTO productCreateDTO);

    ResponseEntity<ProductReadDTO> getProductById(Integer productId);
    ResponseEntity<ProductReadDTO> getMostExpensiveProduct();
    ResponseEntity<ProductReadDTO> getMostSoldProduct();
    ResponseEntity<List<ProductReadDTO>> getProducts();
    ResponseEntity<List<ProductReadDTO>> getProductsOrderedByPriceDesc();
    ResponseEntity<List<ProductReadDTO>> getProductsOrderedByQuantitySOldDesc();

    ResponseEntity<ProductReadDTO> updateProduct(ProductUpdateDTO productUpdateDTO);
}
