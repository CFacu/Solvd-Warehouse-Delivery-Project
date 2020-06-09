package com.solvd.warehouseProject.models;

import java.util.HashMap;
import java.util.List;

public class Warehouse extends AbstractEntity{
    private String name;
    private Double capacity;
    private Integer distanceFromCompany;
    private List<OrderDetail> orderDetails;
    private HashMap<Warehouse, Integer> distances;

    public Warehouse() {
    }
    
    public Warehouse(String name, Double capacity, Integer distanceFromCompany, List<OrderDetail> orderDetails, HashMap<Warehouse, Integer> distances){
        this.name = name;
        this.capacity = capacity;
        this.distanceFromCompany = distanceFromCompany;
        this.orderDetails = orderDetails;
        this.distances = distances;
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

    public Integer getDistanceFromCompany() {
        return distanceFromCompany;
    }

    public void setDistanceFromCompany(Integer distanceFromCompany) {
        this.distanceFromCompany = distanceFromCompany;
    }

    public HashMap<Warehouse, Integer> getDistances() {
        return distances;
    }

    public void setDistances(HashMap<Warehouse, Integer> distances) {
        this.distances = distances;
    }
}
