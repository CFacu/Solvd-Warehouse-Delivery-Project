package com.solvd.warehouseProject.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.solvd.warehouseProject.services.DepositService;
import com.solvd.warehouseProject.services.WarehouseService;

//added days to closest warehouse
public class Company extends AbstractEntity{
    private String name;
    private List<Truck> trucks;
    private List<Warehouse> warehouses;
    private Warehouse closestWarehouse;
    private Integer daysToClosestWarehouse;

    public Company() {
    	this.trucks = new ArrayList<Truck>();
    	this.warehouses = new ArrayList<Warehouse>();
    }
    
    public Company(String name) {
        this.name = name;
        this.trucks = new ArrayList<Truck>();
    	this.warehouses = new ArrayList<Warehouse>();
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


    public Warehouse getClosestWarehouse() {
		return closestWarehouse;
	}

	public void setClosestWarehouse(Warehouse closestWarehouse) {
		this.closestWarehouse = closestWarehouse;
	}

	public Integer getDaysToClosestWarehouse() {
		return daysToClosestWarehouse;
	}

	public void setDaysToClosestWarehouse(Integer daysToClosestWarehouse) {
		this.daysToClosestWarehouse = daysToClosestWarehouse;
	}

	public List<Deposit> deliverOrder(Truck truck, Order order) {
		List<Deposit> deposits = new ArrayList<Deposit>();
		DepositService depositService = new DepositService();
        if (trucks.contains(truck)) {
        	if (truck.getOrders().contains(order)) {
                Warehouse warehouse = this.getClosestWarehouse();
                Integer daysPassed = this.getDaysToClosestWarehouse();
                WarehouseService warehouseService = new WarehouseService();
                Double moneyLost = 0.0;
                LinkedList<OrderDetail> toDeliver = new LinkedList<OrderDetail>(order.sortOrderDetails());    
                OrderDetail orderDetail = toDeliver.poll();
                while (orderDetail != null && warehouse != null) { 
                	while (orderDetail != null && daysPassed >= orderDetail.getProduct().getDaysUntilDueDate()) {
                		moneyLost += orderDetail.getVolumeToDeliver() / orderDetail.getProduct().getVolume() * orderDetail.getProduct().getPrice();
                		LOGGER.info(orderDetail.getVolumeToDeliver()+ " m3 of the Product: "+ orderDetail.getProduct().getName() + " have expired.");
                		orderDetail = toDeliver.poll(); 
                	}
                	if (orderDetail != null) { 
	                	if (warehouse.getAvailableCapacity() > 0) {
	                		if (warehouse.getAvailableCapacity() < orderDetail.getVolumeToDeliver()) {
	                			LOGGER.info(warehouse.getAvailableCapacity()+" m3 of the Product: "+orderDetail.getProduct().getName()+ 
	                    				" have been deposited in "+warehouse.getName());
	                			orderDetail.setVolumeToDeliver(orderDetail.getVolumeToDeliver() - warehouse.getAvailableCapacity());
	                			Deposit deposit = new Deposit (warehouse, orderDetail, warehouse.getAvailableCapacity());
	                			deposits.add(deposit);
	                			warehouse.setAvailableCapacity(0.0);
	                			warehouseService.updateAvailableCapacity(warehouse);
	                		} else {
	                			LOGGER.info((orderDetail.getVolumeToDeliver())+" m3 of the Product: "+orderDetail.getProduct().getName()+ 
	                    				" have been deposited in "+warehouse.getName());
	                			warehouse.setAvailableCapacity(warehouse.getAvailableCapacity()-orderDetail.getVolumeToDeliver());
	                			warehouseService.updateAvailableCapacity(warehouse);
	                			Deposit deposit = new Deposit (warehouse, orderDetail, orderDetail.getVolumeToDeliver());
	                			deposits.add(deposit);
	                			orderDetail.setVolumeToDeliver(0.0);
	                			orderDetail = toDeliver.poll();
	                		}
	                	} else {
	                		daysPassed += warehouse.getDaysToNextWarehouse();
	                		warehouse = warehouse.getNextWarehouse();
	                	}
                	}
                }
        		LOGGER.info("Money lost: $"+moneyLost);
        	}
        }
        deposits.forEach(dep -> depositService.insert(dep));
        return deposits;
	}
	
 }
