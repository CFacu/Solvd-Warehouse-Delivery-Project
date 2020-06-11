package com.solvd.warehouseProject.models;

import java.util.HashMap;
import java.util.List;

public class Warehouse extends AbstractEntity{
    private String name;
    private Double totalCapacity;
    private Double availableCapacity;
    private Integer distanceFromCompany;
    private List<OrderDetail> orderDetails;
    private HashMap<Warehouse, Integer> distances;

    public Warehouse() {
    }
    
    public Warehouse(String name, Double totalCapacity, Integer distanceFromCompany, List<OrderDetail> orderDetails, HashMap<Warehouse, Integer> distances){
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.availableCapacity = totalCapacity;
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

    public Double getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(Double totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

    public Double getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(Double availableCapacity) {
        this.availableCapacity = availableCapacity;
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
