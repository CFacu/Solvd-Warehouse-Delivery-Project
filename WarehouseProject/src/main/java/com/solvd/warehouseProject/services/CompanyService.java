package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.ICompanyDAO;
import com.solvd.warehouseProject.models.Company;

import java.util.List;

public class CompanyService {

	private ICompanyDAO companyDAO;
	
	public CompanyService() {
		companyDAO =  MySessionFactory.getCompanyMapper();
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