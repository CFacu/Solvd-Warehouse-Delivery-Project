package com.solvd.warehouseProject.models;

import java.util.List;

public class Route {
    private Long id;
    private List<Order> orders;

    public Route() {
    }

    public Route(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
