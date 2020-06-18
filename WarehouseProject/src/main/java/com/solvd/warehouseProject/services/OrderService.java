package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.IOrderDAO;
import com.solvd.warehouseProject.models.Order;
import com.solvd.warehouseProject.models.Truck;

public class OrderService {
	
	private IOrderDAO orderDAO;
	private OrderDetailService detailService;

	public OrderService() {
		orderDAO =  MyConnectionFactory.getOrderMapper();
		detailService = new OrderDetailService();
	}
	
	public Order get(Long id){
		Order order = orderDAO.get(id);
		order.setOrderDetails(detailService.getAllByOrderId(order.getId()));
		return order;
	}
	
	public void insert(Order order) {
		orderDAO.insert(order);
	}

	public List<Order> getAll() {
		List<Order> orders = orderDAO.getAll();
		orders.forEach(x -> x.setOrderDetails(detailService.getAllByOrderId(x.getId())));
		return orders;
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

	public List<Order> getAllByTruckId(Long id) {
		List<Order> orders = orderDAO.getAllByTruckId(id);
		orders.forEach(x -> x.setOrderDetails(detailService.getAllByOrderId(x.getId())));
		return orders;
	}
}
