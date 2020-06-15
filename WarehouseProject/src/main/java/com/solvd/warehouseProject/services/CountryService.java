package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.ICountryDAO;
import com.solvd.warehouseProject.models.Country;

public class CountryService {

	private ICountryDAO countryDAO;

	public CountryService() {
		countryDAO =  MySessionFactory.getSessionFactory().openSession(true).getMapper(ICountryDAO.class);
	}
	
	public Country getCountryById(Long id){
		return countryDAO.get(id);
	}
	
	public void insert(Country country) {
		countryDAO.insert(country);
	}
}
