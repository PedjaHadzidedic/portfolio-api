package com.pedja.shopbackend.repository;

import com.pedja.shopbackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}