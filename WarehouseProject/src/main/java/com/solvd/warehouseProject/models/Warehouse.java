package com.solvd.warehouseProject.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement (name = "warehouse")
@XmlType(propOrder = { "name", "totalCapacity", "availableCapacity", "nextWarehouse", "daysToGetToWarehouse"})
public class Warehouse extends AbstractEntity{
    private String name;
    private Double totalCapacity;
    private Double availableCapacity;
    private Warehouse nextWarehouse;
    private Integer daysToGetToWarehouse;

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
    
    
    public Warehouse(String name, Double totalCapacity, Double availableCapacity, Warehouse nextWarehouse, Integer daysToGetToWarehouse){
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.availableCapacity = availableCapacity;
        this.nextWarehouse = nextWarehouse;
        this.daysToGetToWarehouse = daysToGetToWarehouse;
    }
    
    @JsonProperty("warehouse")
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
	
	 @XmlElement(name="days_to_get_to_warehouse")
	@JsonIgnore
	public Integer getDaysToGetToWarehouse() {
		return daysToGetToWarehouse;
	}

	public void setDaysToGetToWarehouse(Integer daysToGetToWarehouse) {
		this.daysToGetToWarehouse = daysToGetToWarehouse;
	}

	@Override
	public String toString() {
		return "Warehouse [name=" + name + ", totalCapacity=" + totalCapacity + ", availableCapacity="
				+ availableCapacity + ", nextWarehouse=" + nextWarehouse + ", daysToGetToWarehouse="
				+ daysToGetToWarehouse + "]";
	}

}
