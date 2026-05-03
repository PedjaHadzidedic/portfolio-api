package com.pedja.shopbackend.controller;

import com.pedja.shopbackend.dto.OrderRequest;
import com.pedja.shopbackend.model.Order;
import com.pedja.shopbackend.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }
}