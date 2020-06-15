package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.ICompanyDAO;
import com.solvd.warehouseProject.models.Company;

public class CompanyService {

	private ICompanyDAO companyDAO;
	
	public CompanyService() {
		companyDAO =  MySessionFactory.getSessionFactory().openSession(true).getMapper(ICompanyDAO.class);
	}
	
	public Company getCompanyById(Long id){
		return companyDAO.get(id);
	}
	
	public void insert(Company company) {
		companyDAO.insert(company);
	}
}
