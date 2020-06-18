package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.IDepositDAO;
import com.solvd.warehouseProject.models.Deposit;
import com.solvd.warehouseProject.models.OrderDetail;
import com.solvd.warehouseProject.models.Warehouse;

public class DepositService {

	private IDepositDAO depositDAO;

	public DepositService() {
		depositDAO =  MyConnectionFactory.getDepositMapper();
	}
	
	public Deposit get(Warehouse warehouse, OrderDetail orderDetail){
		return depositDAO.get(warehouse, orderDetail);
	}
	
	public void insert(Deposit deposit) {
		depositDAO.insert(deposit);
	}

}
