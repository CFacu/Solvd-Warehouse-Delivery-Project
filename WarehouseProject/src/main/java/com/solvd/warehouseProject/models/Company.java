package com.solvd.warehouseProject.models;

import java.util.List;

public class Company extends AbstractEntity{
    private String name;
    private List<Truck> trucks;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public List<Truck> getTrucks() {
		return trucks;
	}

	public void setTrucks(List<Truck> trucks) {
		this.trucks = trucks;
	}
}
