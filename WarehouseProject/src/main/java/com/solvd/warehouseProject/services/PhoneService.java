package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.IPhoneDAO;
import com.solvd.warehouseProject.models.Driver;
import com.solvd.warehouseProject.models.Phone;

public class PhoneService {
    private IPhoneDAO phoneDAO;

    public PhoneService() {
        phoneDAO = MyConnectionFactory.getPhoneMapper();
    }

    public Phone get(Long id){
        return phoneDAO.get(id);
    }

    public List<Phone> getAll() {
        return phoneDAO.getAll();
    }

    public void insert(Phone phone) {
        phoneDAO.insert(phone);
    }

    public void update(Phone phone, Long id) {
        phoneDAO.update(phone, id);
    }

    public void delete(Long id) {
        phoneDAO.delete(id);
    }

    public void addToDriver(Driver driver, Phone phone) {
        phoneDAO.addToDriver(driver, phone);
    }

    public List<Phone> getAllByDriverId(Long id) {
        return phoneDAO.getAllByDriverId(id);
    }
}
