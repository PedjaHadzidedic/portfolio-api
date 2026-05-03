package com.pedja.shopbackend.controller;

import com.pedja.shopbackend.model.Product;
import com.pedja.shopbackend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    // GET products by user ID
    @GetMapping("/user/{userId}")
    public List<Product> getProductsByUser(@PathVariable Long userId) {
        return productService.getProductsByUser(userId);
    }

    // CREATE product
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);
    }

    // CREATE product for specific user
    @PostMapping("/user/{userId}")
    public Product createProductForUser(@PathVariable Long userId,
                                        @Valid @RequestBody Product product) {
        return productService.createProductForUser(userId, product);
    }

    // DELETE product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}