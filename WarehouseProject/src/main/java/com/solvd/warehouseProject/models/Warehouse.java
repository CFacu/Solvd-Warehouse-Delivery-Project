package com.solvd.warehouseProject.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement (name = "warehouse")
@XmlType(propOrder = { "name", "totalCapacity", "availableCapacity", "nextWarehouse", "daysToNextWarehouse"})
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
    
    @XmlElement(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @XmlElement(name="total_capacity")
    @JsonIgnore
    public Double getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(Double totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
	
	 @XmlElement(name="available_capacity")
	@JsonIgnore
    public Double getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(Double availableCapacity) {
        this.availableCapacity = availableCapacity;
    }
    
    @XmlElement(name="next_warehouse")
    @JsonIgnore
    public Warehouse getNextWarehouse() {
		return nextWarehouse;
	}

	public void setNextWarehouse(Warehouse nextWarehouse) {
		this.nextWarehouse = nextWarehouse;
	}
	
	 @XmlElement(name="days_to_next_warehouse")
	@JsonIgnore
	public Integer getDaysToNextWarehouse() {
		return daysToNextWarehouse;
	}

	public void setDaysToNextWarehouse(Integer daysToNextWarehouse) {
		this.daysToNextWarehouse = daysToNextWarehouse;
	}

	@Override
	public String toString() {
		return "Warehouse [name=" + name + ", totalCapacity=" + totalCapacity + ", availableCapacity="
				+ availableCapacity + ", nextWarehouse=" + nextWarehouse + ", daysToNextWarehouse="
				+ daysToNextWarehouse + "]";
	}

}
