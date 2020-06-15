package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.IOrderDAO;
import com.solvd.warehouseProject.models.Order;

public class OrderService {
	
	private IOrderDAO orderDAO;

	public OrderService() {
		orderDAO =  MySessionFactory.getSessionFactory().openSession(true).getMapper(IOrderDAO.class);
	}
	
	public Order getOrderDetailById(Long id){
		return orderDAO.get(id);
	}
	
	public void insert(Order order) {
		orderDAO.insert(order);
	}
}
