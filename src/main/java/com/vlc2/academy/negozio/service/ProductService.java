package com.vlc2.academy.negozio.service;

import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.dto.product.ProductCreateDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.dto.product.ProductUpdateDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {

    // CREATE
    // Save a new product
    @Transactional
    ProductReadDTO createProduct(ProductCreateDTO productCreateDTO);

    // READ
    // Get a product by id
    ProductReadDTO getProductById(Integer id);

    // Get most expensive product
    ProductReadDTO getMostExpensiveProduct();

    // Get all products
    List<ProductReadDTO> getProducts();

    // Get all products ordered by price decrescent
    List<ProductReadDTO> getProductsByPrice();

    // UPDATE
    // Add quantity of a specific product to the stock
    ProductReadDTO updateProduct(ProductUpdateDTO productUpdateDTO);

}
