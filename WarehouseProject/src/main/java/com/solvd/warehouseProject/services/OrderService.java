package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.IOrderDAO;
import com.solvd.warehouseProject.models.Order;
import com.solvd.warehouseProject.models.OrderDetail;
import com.solvd.warehouseProject.models.Truck;

import java.util.List;

public class OrderService {
	
	private IOrderDAO orderDAO;

	public OrderService() {
		orderDAO =  MySessionFactory.getOrderMapper();
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
