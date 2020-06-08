package com.solvd.warehouseProject.models;

import java.util.Date;
import java.util.List;

public class Order {
    private Long id;
    private Date date;
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(Date date, List<OrderDetail> orderDetails) {
        this.date = date;
        this.orderDetails = orderDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
