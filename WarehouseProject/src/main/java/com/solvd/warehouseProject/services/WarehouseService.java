package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.IWarehouseDAO;
import com.solvd.warehouseProject.models.Company;
import com.solvd.warehouseProject.models.Location;
import com.solvd.warehouseProject.models.Warehouse;

import java.util.List;

public class WarehouseService {

	private IWarehouseDAO warehouseDAO;

	public WarehouseService() {
		warehouseDAO =  MyConnectionFactory.getWarehouseMapper();
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

	public void addLocation(Location location, Warehouse warehouse) {
		warehouseDAO.addLocation(location, warehouse);
	}

	public void addToCompany(Company company, Warehouse warehouse) {
		warehouseDAO.addToCompany(company, warehouse);
	}

	public Warehouse getByLocationId(Long id) {
		return warehouseDAO.getByLocationId(id);
	}

	public List<Warehouse> getAllByCompanyId(Long id) {
		return warehouseDAO.getAllByCompanyId(id);
	}
	
	public void updateAvailableCapacity(Warehouse warehouse) {
		warehouseDAO.updateAvailableCapacity(warehouse);
	}

}
