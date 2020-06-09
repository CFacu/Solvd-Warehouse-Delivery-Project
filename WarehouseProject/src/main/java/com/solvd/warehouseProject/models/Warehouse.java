package com.solvd.warehouseProject.models;

import java.util.List;

public class Warehouse extends AbstractEntity{
    private String name;
    private Double capacity;
    private List<OrderDetail> orderDetails;

    public Warehouse() {
    }
    
    public Warehouse(String name, Double capacity, List<OrderDetail> orderDetails) {
        this.name = name;
        this.capacity = capacity;
        this.orderDetails = orderDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
