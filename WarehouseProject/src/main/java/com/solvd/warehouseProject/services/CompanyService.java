package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.ICompanyDAO;
import com.solvd.warehouseProject.models.Company;

public class CompanyService {

	private ICompanyDAO companyDAO;
	private TruckService truckService;
	private WarehouseService warehouseService;
	
	public CompanyService() {
		companyDAO =  MyConnectionFactory.getCompanyMapper();
		truckService = new TruckService();
		warehouseService = new WarehouseService();
	}
	
	public Company get(Long id){
		Company company = companyDAO.get(id);
		company.setTrucks(truckService.getAllByCompanyId(company.getId()));
		company.setWarehouses(warehouseService.getAllByCompanyId(company.getId()));
		return company;
	}

	public List<Company> getAll() {
		List<Company> companies = companyDAO.getAll();
		companies.forEach(x -> {
			x.setTrucks(truckService.getAllByCompanyId(x.getId()));
			x.setWarehouses(warehouseService.getAllByCompanyId(x.getId()));
		});
		return companies;
	}
	
	public void insert(Company company) {
		companyDAO.insert(company);
	}

	public void update(Company company, Long id) {
		companyDAO.update(company, id);
	}

	public void delete(Long id) {
		companyDAO.delete(id);
	}
}