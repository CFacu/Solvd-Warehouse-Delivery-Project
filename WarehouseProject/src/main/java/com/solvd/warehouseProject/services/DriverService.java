package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.IDriverDAO;
import com.solvd.warehouseProject.models.Driver;

public class DriverService {
    private IDriverDAO driverDAO;
    private PhoneService phoneService;

    public DriverService() {
        driverDAO = MyConnectionFactory.getDriverMapper();
        phoneService = new PhoneService();
    }

    public Driver get(Long id) {
        Driver driver = driverDAO.get(id);
        driver.setPhones(phoneService.getAllByDriverId(driver.getId()));
        return driver;
    }

    public void insert(Driver driver) {
        driverDAO.insert(driver);
    }

    public List<Driver> getAll() {
        List<Driver> drivers = driverDAO.getAll();
        drivers.forEach(x -> x.setPhones(phoneService.getAllByDriverId(x.getId())));
        return drivers;
    }

    public void delete(Long id) {
        driverDAO.delete(id);
    }

    public void update(Driver driver, Long id) {
        driverDAO.update(driver, id);
    }

    public List<Driver> getAllByTruckId(Long id) {
        List<Driver> drivers = driverDAO.getAllByTruckId(id);
        drivers.forEach(x -> x.setPhones(phoneService.getAllByDriverId(x.getId())));
        return drivers;
    }
}
