package com.pedja.shopbackend.service;

import com.pedja.shopbackend.dto.OrderItemRequest;
import com.pedja.shopbackend.dto.OrderItemResponse;
import com.pedja.shopbackend.dto.OrderRequest;
import com.pedja.shopbackend.dto.OrderResponse;
import com.pedja.shopbackend.model.*;
import com.pedja.shopbackend.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    // CREATE ORDER (DTO RESPONSE)
    public OrderResponse createOrder(OrderRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order();
        order.setUser(user);

        List<OrderItem> items = new ArrayList<>();
        double total = 0;

        for (OrderItemRequest itemReq : request.getItems()) {

            Product product = productRepository.findById(itemReq.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(itemReq.getQuantity());
            item.setPrice(product.getPrice());
            item.setOrder(order);

            total += product.getPrice() * itemReq.getQuantity();

            items.add(item);
        }

        order.setItems(items);
        order.setTotalPrice(total);

        Order savedOrder = orderRepository.save(order);

        return mapToResponse(savedOrder);
    }

    // GET orders by user (DTO)
    public List<OrderResponse> getOrdersByUser(Long userId) {

        List<Order> orders = orderRepository.findByUserId(userId);
        List<OrderResponse> responses = new ArrayList<>();

        for (Order order : orders) {
            responses.add(mapToResponse(order));
        }

        return responses;
    }

    // MAPPING ENTITY → DTO
    private OrderResponse mapToResponse(Order order) {

        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setUserName(order.getUser().getName());
        response.setTotalPrice(order.getTotalPrice());

        List<OrderItemResponse> itemResponses = new ArrayList<>();

        for (OrderItem item : order.getItems()) {

            OrderItemResponse itemResponse = new OrderItemResponse();
            itemResponse.setProductName(item.getProduct().getName());
            itemResponse.setQuantity(item.getQuantity());
            itemResponse.setPrice(item.getPrice());

            itemResponses.add(itemResponse);
        }

        response.setItems(itemResponses);

        return response;
    }
}
