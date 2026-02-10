package com.vlc2.academy.negozio.controller.impl;

import com.vlc2.academy.negozio.command.ProductCommand;
import com.vlc2.academy.negozio.controller.ProductController;
import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.dto.product.ProductCreateDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.service.ProductService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class ProductControllerImpl implements ProductController {

    private ProductService productService;
    private BeanFactory beanFactory;

    public ProductControllerImpl(ProductService productService, BeanFactory beanFactory){
        this.productService = productService;
        this.beanFactory = beanFactory;
    }

    @PostMapping("/products")
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateDTO productCreateDTO){
        ProductCommand productCommand = beanFactory.getBean(ProductCommand.class, productService, productCreateDTO);
        productCommand.execute();
        return ResponseEntity.ok(null);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductReadDTO> getProductById(@PathVariable Integer productId) {

        return ResponseEntity.ok(productService.getProductById(productId));

    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductReadDTO>> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }
}
