package com.solvd.warehouseProject.models;

import java.util.List;

public class Company {
    private Long id;
    private String name;
    private List<Truck> trucks;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
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
}
