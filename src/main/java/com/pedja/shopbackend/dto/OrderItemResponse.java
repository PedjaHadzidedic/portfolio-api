package com.pedja.shopbackend.dto;

public class OrderItemResponse {

    private String productName;
    private int quantity;
    private Double price;

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}