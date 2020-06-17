package com.solvd.warehouseProject.models;

import java.util.ArrayList;
import java.util.List;

public class City extends AbstractEntity{
    private String name;
    private List<Location> locations;

    public City() {
    	locations = new ArrayList<Location>();
    }

    public City(String name, List<Location> locations) {
        this.name = name;
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public void addLocation(Location location) {
        locations.add(location);
    }
}
