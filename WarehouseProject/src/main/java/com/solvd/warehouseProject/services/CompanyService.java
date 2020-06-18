package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.ICompanyDAO;
import com.solvd.warehouseProject.models.Company;

public class CompanyService {

	private ICompanyDAO companyDAO;
	
	public CompanyService() {
		companyDAO =  MyConnectionFactory.getCompanyMapper();
	}
	
	public Company get(Long id){
		return companyDAO.get(id);
	}

	public List<Company> getAll() {
		return companyDAO.getAll();
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