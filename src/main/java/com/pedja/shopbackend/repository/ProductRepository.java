package com.pedja.shopbackend.repository;

import com.pedja.shopbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}