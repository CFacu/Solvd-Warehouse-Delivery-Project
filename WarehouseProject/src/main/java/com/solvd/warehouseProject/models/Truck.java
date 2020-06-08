package com.solvd.warehouseProject.models;

import java.util.List;

public class Truck {
    private Long id;
    private Double capacity;
    private List<Driver> drivers;
    private List<Order> orders;

    public Truck() {
    }

    public Truck(Double capacity, List<Driver> drivers, List<Order> orders) {
        this.capacity = capacity;
        this.drivers = drivers;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
