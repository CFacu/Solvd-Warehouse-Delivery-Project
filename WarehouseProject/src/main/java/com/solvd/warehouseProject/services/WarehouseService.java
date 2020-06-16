package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.IWarehouseDAO;
import com.solvd.warehouseProject.models.Warehouse;

import java.util.List;

public class WarehouseService {

	private IWarehouseDAO warehouseDAO;

	public WarehouseService() {
		warehouseDAO =  MySessionFactory.getWarehouseMapper();
	}
	
	public Warehouse get(Long id){
		return warehouseDAO.get(id);
	}
	
	public void insert(Warehouse warehouse) {
		warehouseDAO.insert(warehouse);
	}

	public List<Warehouse> getAll() {
		return warehouseDAO.getAll();
	}

	public void delete(Long id) {
		warehouseDAO.delete(id);
	}

	public void update(Warehouse warehouse, Long id) {
		warehouseDAO.update(warehouse, id);
	}
}
