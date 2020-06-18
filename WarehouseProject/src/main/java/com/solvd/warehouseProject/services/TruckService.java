package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.ITruckDAO;
import com.solvd.warehouseProject.models.Company;
import com.solvd.warehouseProject.models.Truck;

import java.util.List;

public class TruckService {

    private ITruckDAO truckDAO;
    private OrderService orderService;
    private DriverService driverService;

    public TruckService() {
        truckDAO = MyConnectionFactory.getTruckMapper();
        orderService = new OrderService();
        driverService = new DriverService();
    }

    public Truck get(Long id){
        Truck truck = truckDAO.get(id);
        truck.setOrders(orderService.getAllByTruckId(truck.getId()));
        truck.setDrivers(driverService.getAllByTruckId(truck.getId()));
        return truck;
    }

    public List<Truck> getAll() {
        List<Truck> trucks = truckDAO.getAll();
        trucks.forEach(x -> {
            x.setOrders(orderService.getAllByTruckId(x.getId()));
            x.setDrivers(driverService.getAllByTruckId(x.getId()));
        });
        return trucks;
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

    public void addToCompany(Company company, Truck truck) {
        truckDAO.addToCompany(company, truck);
    }

    public List<Truck> getAllByCompanyId(Long id){
        List<Truck> trucks = truckDAO.getAllByCompanyId(id);
        trucks.forEach(x -> {
            x.setOrders(orderService.getAllByTruckId(x.getId()));
            x.setDrivers(driverService.getAllByTruckId(x.getId()));
        });
        return trucks;
    }
}
