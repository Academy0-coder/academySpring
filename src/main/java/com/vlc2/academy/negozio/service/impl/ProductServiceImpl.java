package com.vlc2.academy.negozio.service.impl;

import com.vlc2.academy.negozio.dto.product.ProductCreateDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.dto.product.ProductUpdateDTO;
import com.vlc2.academy.negozio.entity.Product;
import com.vlc2.academy.negozio.exceptions.ProductNotFound;
import com.vlc2.academy.negozio.mapper.ProductMapper;
import com.vlc2.academy.negozio.repository.ProductRepository;
import com.vlc2.academy.negozio.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductReadDTO createProduct(ProductCreateDTO productCreateDTO) {

        Product product = new Product(productCreateDTO.getName(), productCreateDTO.getPrice(), productCreateDTO.getQuantityInStock());
        productRepository.save(product);
        return productMapper.toDTO(product);
    }

    @Override
    public ProductReadDTO getProductById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound(String.format("There isn't any product with id = %d",id)));
        return productMapper.toDTO(product);
    }

    @Override
    public ProductReadDTO getMostExpensiveProduct(){
        Product product = productRepository.findMostExpensive().orElseThrow(() -> new ProductNotFound("There's no product"));
        return productMapper.toDTO(product);
    }

    @Override
    public ProductReadDTO getMostSoldProduct() {
        Product product = productRepository.findMostSold().orElseThrow(() -> new ProductNotFound("There's no product"));
        return productMapper.toDTO(product);
    }


    @Override
    public List<ProductReadDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toDTO(products);
    }

    @Override
    public List<ProductReadDTO> getProductsByPrice() {
        List<Product> products = productRepository.orderByPrice();
        return productMapper.toDTO(products);
    }

    @Override
    public List<ProductReadDTO> getProductsByQuantitySold() {
        List<Product> products = productRepository.orderByQuantitySold();
        return productMapper.toDTO(products);
    }


    @Override
    public ProductReadDTO updateProduct(ProductUpdateDTO productUpdateDTO){
        Integer id = productUpdateDTO.getId();
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound(String.format("There isn't any product with id = %d",id)));
        product.setQuantity(product.getQuantity()+productUpdateDTO.getQuantity());
        productRepository.save(product);
        return productMapper.toDTO(product);
    };

}
