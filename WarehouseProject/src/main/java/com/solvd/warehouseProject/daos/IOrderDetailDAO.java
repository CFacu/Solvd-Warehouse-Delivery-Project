package com.solvd.warehouseProject.daos;

import org.apache.ibatis.annotations.Param;

import com.solvd.warehouseProject.models.Order;
import com.solvd.warehouseProject.models.OrderDetail;

public interface IOrderDetailDAO extends IDAO<OrderDetail> {
	
	void addToOrder(@Param("orderDetail")OrderDetail orderDetail, @Param("order")Order order);
}
