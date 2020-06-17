package com.solvd.warehouseProject.models;

import java.util.ArrayList;
import java.util.List;

public class Country extends AbstractEntity{
    private String name;
    private List<City> cities;

    public Country() {
    	cities = new ArrayList<City>();
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

    public void addCity(City city) {
        cities.add(city);
    }
}
