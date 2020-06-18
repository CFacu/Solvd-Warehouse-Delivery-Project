package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.ILocationDAO;
import com.solvd.warehouseProject.models.City;
import com.solvd.warehouseProject.models.Location;

public class LocationService {

    private ILocationDAO locationDAO;

    public LocationService() {
        locationDAO = MyConnectionFactory.getLocationMapper();
    }

    public Location get(Long id){
        return locationDAO.get(id);
    }

    public List<Location> getAll() {
        return locationDAO.getAll();
    }

    public void insert(Location location) {
        locationDAO.insert(location);
    }

    public void update(Location location, Long id) {
        locationDAO.update(location, id);
    }

    public void delete(Long id) {
        locationDAO.delete(id);
    }

    public void addToCity(City city, Location location) {
        locationDAO.addToCity(city, location);
        city.addLocation(location);
    }
}
