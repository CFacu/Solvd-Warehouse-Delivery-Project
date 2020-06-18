package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.IOrderDetailDAO;
import com.solvd.warehouseProject.models.Order;
import com.solvd.warehouseProject.models.OrderDetail;

public class OrderDetailService {

	private IOrderDetailDAO orderDetailDAO;
	private ProductService productService;
	
	public OrderDetailService() {
		orderDetailDAO =  MyConnectionFactory.getOrderDetailMapper();
		productService = new ProductService();
	}
	
	public OrderDetail get(Long id){
		OrderDetail orderDetail = orderDetailDAO.get(id);
		orderDetail.setProduct(productService.getByOrderDetailId(orderDetail.getId()));
		return orderDetail;
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
		List<OrderDetail> orderDetails = orderDetailDAO.getAll();
		orderDetails.forEach(x -> x.setProduct(productService.getByOrderDetailId(x.getId())));
		return orderDetails;
	}

	public void delete(Long id) {
		orderDetailDAO.delete(id);
	}

	public void update(OrderDetail orderDetail, Long id) {
		orderDetailDAO.update(orderDetail, id);
	}

	public List<OrderDetail> getAllByOrderId(Long id) {
		List<OrderDetail> details = orderDetailDAO.getAllByOrderId(id);
		details.forEach(x -> x.setProduct(productService.getByOrderDetailId(x.getId())));
		return details;
	}

}
