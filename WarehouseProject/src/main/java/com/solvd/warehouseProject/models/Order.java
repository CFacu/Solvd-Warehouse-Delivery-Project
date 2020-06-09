package com.solvd.warehouseProject.models;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private Long id;
    private LocalDate date;
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(LocalDate date, List<OrderDetail> orderDetails) {
        this.date = date;
        this.orderDetails = orderDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
