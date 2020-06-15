package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.IOrderDetailDAO;
import com.solvd.warehouseProject.models.Order;
import com.solvd.warehouseProject.models.OrderDetail;

public class OrderDetailService {

	private IOrderDetailDAO orderDetailDAO;
	
	public OrderDetailService() {
		orderDetailDAO =  MySessionFactory.getSessionFactory().openSession(true).getMapper(IOrderDetailDAO.class);
	}
	
	public OrderDetail getOrderDetailById(Long id){
		return orderDetailDAO.get(id);
	}
	
	public void insert(OrderDetail orderDetail) {
		orderDetailDAO.insert(orderDetail);
	}
	
	public void addToOrder(OrderDetail orderDetail, Order order) {
		orderDetailDAO.addToOrder(orderDetail, order);
	}
}
