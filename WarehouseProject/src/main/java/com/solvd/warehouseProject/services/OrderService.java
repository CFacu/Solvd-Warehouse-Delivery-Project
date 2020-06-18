package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.IOrderDAO;
import com.solvd.warehouseProject.models.Order;
import com.solvd.warehouseProject.models.Truck;

public class OrderService {
	
	private IOrderDAO orderDAO;

	public OrderService() {
		orderDAO =  MyConnectionFactory.getOrderMapper();
	}
	
	public Order get(Long id){
		return orderDAO.get(id);
	}
	
	public void insert(Order order) {
		orderDAO.insert(order);
	}

	public List<Order> getAll() {
		return orderDAO.getAll();
	}

	public void delete(Long id) {
		orderDAO.delete(id);
	}

	public void update(Order order, Long id) {
		orderDAO.update(order, id);
	}

	public void updateVolume(Long id) {
		orderDAO.updateVolume(id);
	}

	public void updatePrice(Long id) {
		orderDAO.updatePrice(id);
	}

	public void addToTruck(Truck truck, Order order) {
		orderDAO.addToTruck(truck, order);
	}
}
