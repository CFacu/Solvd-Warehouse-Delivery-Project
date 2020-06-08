package com.solvd.warehouseProject.models;

import java.util.Date;
import java.util.List;

public class Product {
    private Long id;
    private String name;
    private String description;
    private Double volume;
    private Date dueDate;
    private Double price;
    private List<OrderDetail> orderDetails;

    public Product() {
    }

    public Product(String name, String description, Double volume, Date dueDate, Double price, List<OrderDetail> orderDetails) {
        this.name = name;
        this.description = description;
        this.volume = volume;
        this.dueDate = dueDate;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
