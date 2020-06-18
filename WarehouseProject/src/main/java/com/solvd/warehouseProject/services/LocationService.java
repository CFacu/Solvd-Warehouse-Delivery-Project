package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.ILocationDAO;
import com.solvd.warehouseProject.models.City;
import com.solvd.warehouseProject.models.Location;

public class LocationService {

    private ILocationDAO locationDAO;
    private WarehouseService warehouseService;

    public LocationService() {
        locationDAO = MyConnectionFactory.getLocationMapper();
        warehouseService = new WarehouseService();
    }

    public Location get(Long id){
        Location location = locationDAO.get(id);
        location.setWarehouse(warehouseService.getByLocationId(location.getId()));
        return location;
    }

    public List<Location> getAll() {
        List<Location> locations = locationDAO.getAll();
        locations.forEach(x -> x.setWarehouse(warehouseService.getByLocationId(x.getId())));
        return locations;
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

    public List<Location> getAllByCityId(Long id) {
        List<Location> locations = locationDAO.getAllByCityId(id);
        locations.forEach(x -> x.setWarehouse(warehouseService.getByLocationId(x.getId())));
        return locations;
    }
}
