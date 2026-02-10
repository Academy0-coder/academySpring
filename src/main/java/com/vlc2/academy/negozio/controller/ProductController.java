package com.vlc2.academy.negozio.controller;

import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.dto.product.ProductCreateDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController {

    ResponseEntity<Void> createProduct(ProductCreateDTO productCreateDTO);

    ResponseEntity<ProductReadDTO> getProductById(Integer productId);
    ResponseEntity<List<ProductReadDTO>> getProducts();
}
