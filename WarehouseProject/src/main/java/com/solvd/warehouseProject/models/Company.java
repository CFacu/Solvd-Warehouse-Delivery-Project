package com.solvd.warehouseProject.models;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.solvd.warehouseProject.parsers.JsonParser;
import com.solvd.warehouseProject.services.DepositService;
import com.solvd.warehouseProject.services.WarehouseService;

@XmlRootElement (name = "company")
@XmlType(propOrder = { "name", "trucks", "warehouses" })
public class Company extends AbstractEntity{
    private String name;
    private List<Truck> trucks;
    private List<Warehouse> warehouses;

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
    
    @XmlElement (name= "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @XmlElementWrapper(name="trucks")
    @XmlElement(name="truck")
	public List<Truck> getTrucks() {
		return trucks;
	}

	public void setTrucks(List<Truck> trucks) {
		this.trucks = trucks;
	}
	
	@XmlElementWrapper(name="warehouses")
    @XmlElement(name="warehouse")
    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    @XmlTransient
    public Warehouse getClosestWarehouse() {
		return warehouses.get(0);
	}
    
    



	public List<Deposit> deliverOrder(Truck truck, Order order) {
		List<Deposit> deposits = new ArrayList<Deposit>();
		//DepositService depositService = new DepositService();
        if (trucks.contains(truck)) {
        	if (truck.getOrders().contains(order)) {
                Warehouse warehouse = this.getClosestWarehouse();
                Integer daysPassed = warehouse.getDaysToGetToWarehouse();
                //WarehouseService warehouseService = new WarehouseService();
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
	                			//warehouseService.updateAvailableCapacity(warehouse);
	                		} else {
	                			LOGGER.info((orderDetail.getVolumeToDeliver())+" m3 of the Product: "+orderDetail.getProduct().getName()+ 
	                    				" have been deposited in "+warehouse.getName());
	                			warehouse.setAvailableCapacity(warehouse.getAvailableCapacity()-orderDetail.getVolumeToDeliver());
	                			//warehouseService.updateAvailableCapacity(warehouse);
	                			Deposit deposit = new Deposit (warehouse, orderDetail, orderDetail.getVolumeToDeliver());
	                			deposits.add(deposit);
	                			orderDetail.setVolumeToDeliver(0.0);
	                			orderDetail = toDeliver.poll();
	                		}
	                	} else {
	                		warehouse = warehouse.getNextWarehouse();	                		
	                		daysPassed += warehouse.getDaysToGetToWarehouse();
	                	}
                	}
                }
        		LOGGER.info("Money lost: $"+moneyLost);
        	}
        }
        //deposits.forEach(depositService::insert);
        //JsonParser.objectListToJson(deposits, "src/main/resources/deposits-output.json"); 
        try {
			JsonParser.jsonOutput(deposits, "src/main/resources/deposits-output2.json");
		} catch (IOException e) {
			LOGGER.error(e);
		}
        return deposits;
	}
	
 }
