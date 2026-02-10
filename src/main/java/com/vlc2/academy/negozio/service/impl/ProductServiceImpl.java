package com.vlc2.academy.negozio.service.impl;

import com.vlc2.academy.negozio.dto.product.ProductCreateDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.entity.Product;
import com.vlc2.academy.negozio.mapper.ProductMapper;
import com.vlc2.academy.negozio.repository.ProductRepository;
import com.vlc2.academy.negozio.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductReadDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductReadDTO> productReadDTO = products.stream()
                .map(product -> productMapper.toDTO(product))
                .toList();
        return productReadDTO;
    }

    @Override
    public void createProduct(ProductCreateDTO productCreateDTO) {

        Product product = new Product(productCreateDTO.getName(), productCreateDTO.getPrice(), productCreateDTO.getQuantityInStock());

        productRepository.save(product);
    }
}
