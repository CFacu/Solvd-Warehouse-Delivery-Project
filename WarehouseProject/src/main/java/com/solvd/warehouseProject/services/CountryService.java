package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.ICountryDAO;
import com.solvd.warehouseProject.models.Country;

import java.util.List;

public class CountryService {

	private ICountryDAO countryDAO;

	public CountryService() {
		countryDAO =  MySessionFactory.getCountryMapper();
	}
	
	public Country get(Long id){
		return countryDAO.get(id);
	}
	
	public void insert(Country country) {
		countryDAO.insert(country);
	}

	public void delete(Long id) {
		countryDAO.delete(id);
	}

	public void update(Country country, Long id) {
		countryDAO.update(country, id);
	}

	public List<Country> getAll() {
		return countryDAO.getAll();
	}
}
