package com.solvd.warehouseProject.models;

import com.solvd.warehouseProject.exceptions.OrderVolumeExceededException;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement (name = "truck")
@XmlType(propOrder = { "capacity", "drivers", "orders"})
public class Truck extends AbstractEntity{
    private Double capacity;
    private List<Driver> drivers;
    private List<Order> orders;

    public Truck() {
    	this.orders = new ArrayList<Order>();
    	this.drivers = new ArrayList<Driver>();
    }

    public Truck(Double capacity) {
    	this.capacity = capacity;
    	this.orders = new ArrayList<Order>();
    	this.drivers = new ArrayList<Driver>();
    }
    
    public Truck(Double capacity, List<Driver> drivers, List<Order> orders) {
        this.capacity = capacity;
        this.drivers = drivers;
        this.orders = orders;
    }
    
    @XmlElement(name="capacity")
    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }
    
    @XmlElementWrapper(name="drivers")
    @XmlElement(name="driver")
    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
    
    @XmlElementWrapper(name="orders")
    @XmlElement(name="order")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) throws OrderVolumeExceededException {
        order.calculateTotalVolume();
        if (order.getTotalVolume() <= capacity) {
            orders.add(order);
        } else {
            throw new OrderVolumeExceededException("The total volume of the order exceed the truck's capacity.");
        }
    }


}