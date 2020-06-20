package com.solvd.warehouseProject.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.solvd.warehouseProject.parsers.LocalDateAdapter;

@XmlRootElement (name = "order")
@XmlType(propOrder = { "date", "orderDetails"})
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
    
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement(name="date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    @XmlElementWrapper(name="order_details")
    @XmlElement(name="order_detail")
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @XmlTransient
    public Double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }
    
    @XmlTransient
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
    
    public void calculateDaysUntilDueDate () {
    	this.getOrderDetails().forEach(od -> od.getProduct().setDaysUntilDueDate(new Long(ChronoUnit.DAYS.between(this.getDate(), od.getProduct().getDueDate())).intValue()));
    }
    
    public List<OrderDetail> sortOrderDetails () { 
    	List<OrderDetail> sortedOrderDetails = this.getOrderDetails();
    	sortedOrderDetails.sort((OrderDetail od1, OrderDetail od2) -> 
			(new Double(od2.getSubtotalPrice()/od2.getProduct().getDaysUntilDueDate()/od2.getSubtotalVolume()).compareTo(
					(new Double(od1.getSubtotalPrice()/od1.getProduct().getDaysUntilDueDate()/od1.getSubtotalVolume())))));
    	return sortedOrderDetails;
    }
}