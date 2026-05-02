package com.pedja.shopbackend.service;

import com.pedja.shopbackend.model.Product;
import com.pedja.shopbackend.model.User;
import com.pedja.shopbackend.repository.ProductRepository;
import com.pedja.shopbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    // CONSTRUCTOR
    public ProductService(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    // GET all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // CREATE product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // CREATE product for specific user
    public Product createProductForUser(Long userId, Product product) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        product.setUser(user);

        return productRepository.save(product);
    }

    // DELETE product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}