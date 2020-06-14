package com.solvd.warehouseProject.models;

import java.util.List;

//removed distance from company, added nextWarehouse, daysToNextWarehouse
public class Warehouse extends AbstractEntity{
    private String name;
    private Double totalCapacity;
    private Double availableCapacity;
    private List<OrderDetail> orderDetails;
    private Warehouse nextWarehouse;
    private Integer daysToNextWarehouse;

    public Warehouse() {
    }
    
    public Warehouse(String name, Double totalCapacity, Double availableCapacity){
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.availableCapacity = availableCapacity;
    }
    
    public Warehouse(String name, Double totalCapacity, List<OrderDetail> orderDetails){
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.availableCapacity = totalCapacity;
        this.orderDetails = orderDetails;
    }
    
    public Warehouse(String name, Double totalCapacity, Double availableCapacity, List<OrderDetail> orderDetails){
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.availableCapacity = availableCapacity;
        this.orderDetails = orderDetails;
    }
    
    public Warehouse(String name, Double totalCapacity, Double availableCapacity, Warehouse nextWarehouse, Integer daysToNextWarehouse){
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.availableCapacity = availableCapacity;
        this.nextWarehouse = nextWarehouse;
        this.daysToNextWarehouse = daysToNextWarehouse;
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

    public Warehouse getNextWarehouse() {
		return nextWarehouse;
	}

	public void setNextWarehouse(Warehouse nextWarehouse) {
		this.nextWarehouse = nextWarehouse;
	}

	public Integer getDaysToNextWarehouse() {
		return daysToNextWarehouse;
	}

	public void setDaysToNextWarehouse(Integer daysToNextWarehouse) {
		this.daysToNextWarehouse = daysToNextWarehouse;
	}

}
