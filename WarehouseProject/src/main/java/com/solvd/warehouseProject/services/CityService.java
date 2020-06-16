package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.ICityDAO;
import com.solvd.warehouseProject.models.City;
import com.solvd.warehouseProject.models.Country;

import java.util.List;

public class CityService {

    private ICityDAO cityDAO;

    public CityService() {
        cityDAO = MySessionFactory.getCityMapper();
    }

    public City get(Long id){
        return cityDAO.get(id);
    }

    public List<City> getAll() {
        return cityDAO.getAll();
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
}
