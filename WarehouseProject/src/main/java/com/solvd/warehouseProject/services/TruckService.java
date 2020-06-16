package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.ITruckDAO;
import com.solvd.warehouseProject.models.Truck;

import java.util.List;

public class TruckService {

    private ITruckDAO truckDAO;

    public TruckService() {
        truckDAO = MySessionFactory.getTruckMapper();
    }

    public Truck get(Long id){
        return truckDAO.get(id);
    }

    public List<Truck> getAll() {
        return truckDAO.getAll();
    }

    public void insert(Truck truck) {
        truckDAO.insert(truck);
    }

    public void update(Truck truck, Long id) {
        truckDAO.update(truck, id);
    }

    public void delete(Long id) {
        truckDAO.delete(id);
    }
}
