package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.IOrderDAO;
import com.solvd.warehouseProject.models.Order;
import com.solvd.warehouseProject.models.OrderDetail;

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

	public void updateVolume(Double totalVolume, Long id) {
		orderDAO.updateVolume(totalVolume, id);
	}

	public void updatePrice(Double totalPrice, Long id) {
		orderDAO.updatePrice(totalPrice, id);
	}
}
