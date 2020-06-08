package com.solvd.warehouseProject.models;

import java.util.List;

public class Warehouse {
    private Long id;
    private String name;
    private List<OrderDetail> orderDetails;

    public Warehouse() {
    }

    public Warehouse(String name, List<OrderDetail> orderDetails) {
        this.name = name;
        this.orderDetails = orderDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
