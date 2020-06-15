package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.IWarehouseDAO;
import com.solvd.warehouseProject.models.Warehouse;

public class WarehouseService {

	private IWarehouseDAO warehouseDAO;

	public WarehouseService() {
		warehouseDAO =  MySessionFactory.getSessionFactory().openSession(true).getMapper(IWarehouseDAO.class);
	}
	
	public Warehouse getCountryById(Long id){
		return warehouseDAO.get(id);
	}
	
	public void insert(Warehouse warehouse) {
		warehouseDAO.insert(warehouse);
	}
}
