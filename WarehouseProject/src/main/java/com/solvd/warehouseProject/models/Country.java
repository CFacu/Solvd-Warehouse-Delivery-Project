package com.solvd.warehouseProject.models;

import java.util.List;

public class Country extends AbstractEntity{
    private String name;
    private List<City> cities;

    public Country() {
    }

    public Country(String name, List<City> cities) {
        this.name = name;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
