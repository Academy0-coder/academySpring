package com.vlc2.academy.negozio.service;

import com.vlc2.academy.negozio.dto.product.ProductCreateDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;

import java.util.List;

public interface ProductService {

    // CREATE
    // Save a new product
    void createProduct(ProductCreateDTO productCreateDTO);

    // READ
    // Get all products
    List<ProductReadDTO> getProducts();
}
