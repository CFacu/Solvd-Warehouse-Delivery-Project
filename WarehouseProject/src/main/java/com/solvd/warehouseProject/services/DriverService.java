package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.IDriverDAO;
import com.solvd.warehouseProject.models.Driver;

public class DriverService {
    private IDriverDAO driverDAO;

    public DriverService() {
        driverDAO = MyConnectionFactory.getDriverMapper();
    }

    public Driver get(Long id) {
        return driverDAO.get(id);
    }

    public void insert(Driver driver) {
        driverDAO.insert(driver);
    }

    public List<Driver> getAll() {
        return driverDAO.getAll();
    }

    public void delete(Long id) {
        driverDAO.delete(id);
    }

    public void update(Driver driver, Long id) {
        driverDAO.update(driver, id);
    }
}
