package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.IProductDAO;
import com.solvd.warehouseProject.models.Product;

public class ProductService {

	private IProductDAO productDAO;
	
	public ProductService() {
		productDAO =  MySessionFactory.getSessionFactory().openSession(true).getMapper(IProductDAO.class);
	}
	
	public Product getProductById(Long id){
		return productDAO.get(id);
	}
	
	public void insert(Product product) {
		productDAO.insert(product);
	}
}
