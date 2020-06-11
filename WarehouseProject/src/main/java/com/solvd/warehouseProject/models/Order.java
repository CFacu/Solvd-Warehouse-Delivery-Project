package com.solvd.warehouseProject.models;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class Order extends AbstractEntity{
    private LocalDate date;
    private List<OrderDetail> orderDetails;
    private Double totalVolume;
    private Double totalPrice;

    public Order() {
    }

    public Order(LocalDate date, List<OrderDetail> orderDetails) {
        this.date = date;
        this.orderDetails = orderDetails;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void calculateTotalVolume() {
        Stream.iterate(0, i -> i + 1).limit(orderDetails.size()).forEach(x -> {
            totalVolume += orderDetails.get(x).getSubtotalVolume();
        });
    }

    public void calculateTotalPrice() {
        Stream.iterate(0, i -> i + 1).limit(orderDetails.size()).forEach(x -> {
            totalPrice += orderDetails.get(x).getSubtotalPrice();
        });
    }
}