package com.solvd.warehouseProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Warehouse extends AbstractEntity{
    private String name;
    private Double totalCapacity;
    private Double availableCapacity;
    private Warehouse nextWarehouse;
    private Integer daysToNextWarehouse;

    public Warehouse() {
    }
    
    public Warehouse(String name, Double totalCapacity, Double availableCapacity){
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.availableCapacity = availableCapacity;
    }
    
    public Warehouse(String name, Double totalCapacity){
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.availableCapacity = totalCapacity;
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
    
    @JsonIgnore
    public Double getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(Double totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
	
	@JsonIgnore
    public Double getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(Double availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    @JsonIgnore
    public Warehouse getNextWarehouse() {
		return nextWarehouse;
	}

	public void setNextWarehouse(Warehouse nextWarehouse) {
		this.nextWarehouse = nextWarehouse;
	}
	
	@JsonIgnore
	public Integer getDaysToNextWarehouse() {
		return daysToNextWarehouse;
	}

	public void setDaysToNextWarehouse(Integer daysToNextWarehouse) {
		this.daysToNextWarehouse = daysToNextWarehouse;
	}

}
