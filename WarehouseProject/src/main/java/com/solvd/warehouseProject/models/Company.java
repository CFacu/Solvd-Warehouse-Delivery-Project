package com.solvd.warehouseProject.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

	public void deliverOrder(Truck truck, Order order) {
        if (trucks.contains(truck)) {
        	if (truck.getOrders().contains(order)) {
                Warehouse warehouse = this.getClosestWarehouse();
                Integer daysPassed = this.getDaysToClosestWarehouse();
                Double moneyLost = 0.0;
                LinkedList<OrderDetail> toDeliver = new LinkedList<OrderDetail>(order.sortOrderDetails()); //we could implement a priority queue with a comparator; i did the sorting using lambda expressions   
                OrderDetail orderDetail = toDeliver.poll();
                while (orderDetail != null && warehouse != null) { //if orderDetail is null it means that there are no more orders to be delivered, if warehouse is null it means we have already visited all of them
                	if (daysPassed >= orderDetail.getProduct().getDaysUntilDueDate()) {
                		moneyLost += orderDetail.getVolumeToDeliver() / orderDetail.getProduct().getVolume() * orderDetail.getProduct().getPrice();
                		LOGGER.info(orderDetail.getVolumeToDeliver()+ " u.v of the Product: "+ orderDetail.getProduct().getName() + " have expired.");
                		orderDetail = toDeliver.poll(); 
                	}
                	if (orderDetail != null) { //i do this control because orderDetail can get a null value two lines above and if that happens some exceptions will be thrown when trying to access its fields
	                	if (warehouse.getAvailableCapacity() > 0) {
	                		if (warehouse.getAvailableCapacity() < orderDetail.getVolumeToDeliver()) {
	                			LOGGER.info(warehouse.getAvailableCapacity()+" v.u of the Product: "+orderDetail.getProduct().getName()+ //here we should start building the string that'll be our output
	                    				" have been deposited in "+warehouse.getName());
	                			orderDetail.setVolumeToDeliver(orderDetail.getVolumeToDeliver() - warehouse.getAvailableCapacity());
	                			warehouse.setAvailableCapacity(0.0);
	                		} else {
	                			LOGGER.info((orderDetail.getVolumeToDeliver())+" v.u of the Product: "+orderDetail.getProduct().getName()+ 
	                    				" have been deposited in "+warehouse.getName());
	                			warehouse.setAvailableCapacity(warehouse.getAvailableCapacity()-orderDetail.getVolumeToDeliver());
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
	}
	
 }
