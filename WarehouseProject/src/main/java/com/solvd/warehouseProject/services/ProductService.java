package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.IProductDAO;
import com.solvd.warehouseProject.models.Product;

public class ProductService {

	private IProductDAO productDAO;
	
	public ProductService() {
		productDAO =  MyConnectionFactory.getProductMapper();
	}
	
	public Product get(Long id){
		return productDAO.get(id);
	}
	
	public void insert(Product product) {
		productDAO.insert(product);
	}

	public List<Product> getAll() {
		return productDAO.getAll();
	}

	public void delete(Long id) {
		productDAO.delete(id);
	}

	public void update(Product product, Long id) {
		productDAO.update(product, id);
	}
}
