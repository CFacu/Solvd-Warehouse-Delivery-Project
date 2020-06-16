package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.IPhoneDAO;
import com.solvd.warehouseProject.models.Driver;
import com.solvd.warehouseProject.models.Phone;

import java.util.List;

public class PhoneService {
    private IPhoneDAO phoneDAO;

    public PhoneService() {
        phoneDAO = MySessionFactory.getPhoneMapper();
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
}
