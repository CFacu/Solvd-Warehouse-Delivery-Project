package com.solvd.warehouseProject.models;

import java.util.List;

public class Company extends AbstractEntity{
    private String name;
    private List<Truck> trucks;
    private List<Warehouse> warehouses;

    public Company() {
    }

    public Company(String name, List<Warehouse> warehouses) {
        this.name = name;
        this.warehouses = warehouses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public List<Truck> getTrucks() {
		return trucks;
	}

	public void setTrucks(List<Truck> trucks) {
		this.trucks = trucks;
	}

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public Warehouse getNearestWarehouseToCompany() {
        if (!warehouses.isEmpty()) {
            Warehouse warehouse = warehouses.get(0);
            for (Warehouse w : warehouses) {
                if (w.getDistanceFromCompany() < warehouse.getDistanceFromCompany()) {
                    warehouse = w;
                }
            }
            return warehouse;
        }else {
            //NoWarehousesException
            return null;
        }
    }

    public void deliverOrder(Truck truck, Order order) {
        if (trucks.contains(truck)) {
            if (!truck.getOrders().isEmpty()) {
                if (truck.getOrders().contains(order)) {
                    List<OrderDetail> toDeliver = order.getOrderDetails();
                    Warehouse warehouse = getNearestWarehouseToCompany(); //Here should get the optimal warehouse considering due date and volume
                    while (toDeliver.size() > 0) {
                        if (warehouse.getAvailableCapacity() >= toDeliver.get(0).getSubtotalVolume()){
                            warehouse.setAvailableCapacity(warehouse.getAvailableCapacity() - toDeliver.get(0).getSubtotalVolume());
                            toDeliver.remove(0);
                        } else {
                            //warehouse = nextWarehouse(); Here should get the next optimal warehouse considering due date and volume
                        }
                    }
                }
            }
        }
    }
}