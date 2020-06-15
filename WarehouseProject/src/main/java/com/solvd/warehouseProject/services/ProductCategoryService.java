package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.connection.MySessionFactory;
import com.solvd.warehouseProject.daos.IProductCategoryDAO;
import com.solvd.warehouseProject.models.ProductCategory;

public class ProductCategoryService {

	private IProductCategoryDAO productCategoryDAO;
	
	public ProductCategoryService() {
		productCategoryDAO =  MySessionFactory.getSessionFactory().openSession(true).getMapper(IProductCategoryDAO.class);
	}
	
	public ProductCategory getCompanyById(Long id){
		return productCategoryDAO.get(id);
	}
	
	public void insert(ProductCategory productCategory) {
		productCategoryDAO.insert(productCategory);
	}
}
