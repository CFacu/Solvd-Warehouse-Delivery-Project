package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.IProductCategoryDAO;
import com.solvd.warehouseProject.models.ProductCategory;

public class ProductCategoryService {

	private IProductCategoryDAO productCategoryDAO;
	
	public ProductCategoryService() {
		productCategoryDAO =  MyConnectionFactory.getProductCategoryMapper();
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

	public ProductCategory getByProductId(Long id) {
		return productCategoryDAO.getByProductId(id);
	}
}
