package com.pedja.shopbackend.service;

import com.pedja.shopbackend.model.Product;
import com.pedja.shopbackend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // GET all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // CREATE product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // DELETE product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}