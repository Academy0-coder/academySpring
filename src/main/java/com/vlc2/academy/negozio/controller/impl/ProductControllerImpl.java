package com.vlc2.academy.negozio.controller.impl;

import com.vlc2.academy.negozio.command.ProductCreateCommand;
import com.vlc2.academy.negozio.command.ProductUpdateCommand;
import com.vlc2.academy.negozio.controller.ProductController;
import com.vlc2.academy.negozio.dto.product.ProductCreateDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.dto.product.ProductUpdateDTO;
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
    public ResponseEntity<ProductReadDTO> createProduct(@RequestBody ProductCreateDTO productCreateDTO){
        ProductCreateCommand productCreateCommand = beanFactory.getBean(ProductCreateCommand.class, productService, productCreateDTO);
        return ResponseEntity.ok(productCreateCommand.execute());
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductReadDTO> getProductById(@PathVariable Integer productId) {
        return ResponseEntity.ok(productService.getProductById(productId));

    }

    @GetMapping("/products/price/first")
    public ResponseEntity<ProductReadDTO> getMostExpensiveProduct() {
        return ResponseEntity.ok(productService.getMostExpensiveProduct());
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductReadDTO>> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/products/price/all")
    public ResponseEntity<List<ProductReadDTO>> getProductsOrderedByPriceDesc() {
        return ResponseEntity.ok(productService.getProductsByPrice());
    }

    @PatchMapping("/products")
    public ResponseEntity<ProductReadDTO> updateProduct(@RequestBody ProductUpdateDTO productUpdateDTO){
        ProductUpdateCommand productUpdateCommand = beanFactory.getBean(ProductUpdateCommand.class, productService, productUpdateDTO);
        return ResponseEntity.ok(productUpdateCommand.execute());
    }
}
