package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.ICityDAO;
import com.solvd.warehouseProject.daos.ICountryDAO;
import com.solvd.warehouseProject.models.Country;

public class CountryService {

	private ICountryDAO countryDAO;
	private CityService cityDAO;

	public CountryService() {
		countryDAO =  MyConnectionFactory.getCountryMapper();
		cityDAO = new CityService();
	}
	
	public Country get(Long id){
		Country country = countryDAO.get(id);
		country.setCities(cityDAO.getAllByCountryId(country.getId()));
		return country;
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
		List<Country> countries = countryDAO.getAll();
		countries.forEach(x-> {
			x.setCities(cityDAO.getAllByCountryId(x.getId()));
		});
		return countries;
	}
}
