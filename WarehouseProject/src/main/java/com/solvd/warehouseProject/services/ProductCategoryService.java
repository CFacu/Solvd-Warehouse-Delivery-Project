package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.IProductCategoryDAO;
import com.solvd.warehouseProject.models.ProductCategory;

import java.util.List;

public class ProductCategoryService {

	private IProductCategoryDAO productCategoryDAO;
	
	public ProductCategoryService() {
		productCategoryDAO =  MySessionFactory.getProductCategoryMapper();
	}
	
	public ProductCategory get(Long id){
		return productCategoryDAO.get(id);
	}
	
	public void insert(ProductCategory productCategory) {
		productCategoryDAO.insert(productCategory);
	}

	public List<ProductCategory> getAll() {
		return productCategoryDAO.getAll();
	}

	public void delete(Long id) {
		productCategoryDAO.delete(id);
	}

	public void update(ProductCategory productCategory, Long id) {
		productCategoryDAO.update(productCategory, id);
	}
}
