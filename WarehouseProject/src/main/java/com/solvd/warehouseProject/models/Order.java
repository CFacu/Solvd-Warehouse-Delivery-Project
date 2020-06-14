package com.solvd.warehouseProject.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Order extends AbstractEntity{
    private LocalDate date;
    private List<OrderDetail> orderDetails;
    private Double totalVolume;
    private Double totalPrice;

    public Order() {
    	this.orderDetails = new ArrayList<OrderDetail>();
    	this.totalVolume = 0.0; 
    	this.totalPrice = 0.0;
    }

    public Order(LocalDate date, List<OrderDetail> orderDetails) {
        this.date = date;
        this.orderDetails = orderDetails;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void calculateTotalVolume() {
        this.getOrderDetails().forEach(orderDetail -> {
        	this.totalVolume += orderDetail.getSubtotalVolume();
        });
    }

    public void calculateTotalPrice() {
        Stream.iterate(0, i -> i + 1).limit(orderDetails.size()).forEach(x -> {
            totalPrice += orderDetails.get(x).getSubtotalPrice();
        });
    }
    
    public void addOrderDetail (OrderDetail orderDetail) { //any controls that need to be added?
    	orderDetail.getProduct().setDaysUntilDueDate(new Long(ChronoUnit.DAYS.between(this.getDate(), orderDetail.getProduct().getDueDate())).intValue());
    	this.getOrderDetails().add(orderDetail);
    }
    
    public List<OrderDetail> sortOrderDetails () { //dont know why but it's sorting the original order details list
    	List<OrderDetail> sortedOrderDetails = this.getOrderDetails();
    	sortedOrderDetails.sort((OrderDetail od1, OrderDetail od2) -> 
			(new Double(od2.getSubtotalPrice()/od2.getProduct().getDaysUntilDueDate()).compareTo(
					(new Double(od1.getSubtotalPrice()/od1.getProduct().getDaysUntilDueDate())))));
    	return sortedOrderDetails;
    }
}