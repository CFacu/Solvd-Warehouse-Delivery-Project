package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.ICityDAO;
import com.solvd.warehouseProject.daos.ICountryDAO;
import com.solvd.warehouseProject.daos.ILocationDAO;
import com.solvd.warehouseProject.models.City;
import com.solvd.warehouseProject.models.Country;

public class CityService {

    private ICityDAO cityDAO;
    private LocationService locationDAO;

    public CityService() {
        cityDAO = MyConnectionFactory.getCityMapper();
        locationDAO = new LocationService();
    }

    public City get(Long id){
        City city = cityDAO.get(id);
        city.setLocations(locationDAO.getAllByCityId(city.getId()));
        return city;
    }

    public List<City> getAll() {
        List<City> cities = cityDAO.getAll();
        cities.forEach(x -> x.setLocations(locationDAO.getAllByCityId(x.getId())));
        return cities;
    }

    public void insert(City city) {
        cityDAO.insert(city);
    }

    public void update(City city, Long id) {
        cityDAO.update(city, id);
    }

    public void delete(Long id) {
        cityDAO.delete(id);
    }

    public void addToCountry(Country country, City city) {
        cityDAO.addToCountry(country, city);
        country.addCity(city);
    }

    public List<City> getAllByCountryId(Long id) {
        List<City> cities = cityDAO.getAllByCountryId(id);
        cities.forEach(x -> x.setLocations(locationDAO.getAllByCityId(x.getId())));
        return cities;
    }
}
