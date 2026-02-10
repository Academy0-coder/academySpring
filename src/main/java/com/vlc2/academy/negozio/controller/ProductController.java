package com.vlc2.academy.negozio.controller;

import com.vlc2.academy.negozio.dto.product.ProductCreateDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController {

    ResponseEntity<List<ProductReadDTO>> getProducts();
    ResponseEntity<Void> createProduct(ProductCreateDTO productCreateDTO);
}
