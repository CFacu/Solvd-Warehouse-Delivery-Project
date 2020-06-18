package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.IOrderDetailDAO;
import com.solvd.warehouseProject.models.Order;
import com.solvd.warehouseProject.models.OrderDetail;

public class OrderDetailService {

	private IOrderDetailDAO orderDetailDAO;
	
	public OrderDetailService() {
		orderDetailDAO =  MyConnectionFactory.getOrderDetailMapper();
	}
	
	public OrderDetail get(Long id){
		return orderDetailDAO.get(id);
	}
	
	public void insert(OrderDetail orderDetail) {
		orderDetailDAO.insert(orderDetail);
	}
	
	public void addToOrder(OrderDetail orderDetail, Order order) {
		OrderService orderService = new OrderService();
		orderDetailDAO.addToOrder(orderDetail, order);
		orderService.updatePrice(order.getId());
		orderService.updateVolume(order.getId());
	}

	public List<OrderDetail> getAll() {
		return orderDetailDAO.getAll();
	}

	public void delete(Long id) {
		orderDetailDAO.delete(id);
	}

	public void update(OrderDetail orderDetail, Long id) {
		orderDetailDAO.update(orderDetail, id);
	}
}
