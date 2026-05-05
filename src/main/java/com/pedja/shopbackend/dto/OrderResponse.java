package com.pedja.shopbackend.dto;

import java.util.List;

public class OrderResponse {

    private Long id;
    private String userName;
    private Double totalPrice;
    private List<OrderItemResponse> items;

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public List<OrderItemResponse> getItems() {
        return items;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setItems(List<OrderItemResponse> items) {
        this.items = items;
    }
}