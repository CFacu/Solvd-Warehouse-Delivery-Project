package com.solvd.warehouseProject.services;

import java.util.List;

import com.solvd.warehouseProject.connection.MyConnectionFactory;
import com.solvd.warehouseProject.daos.IProductDAO;
import com.solvd.warehouseProject.models.Product;
import com.solvd.warehouseProject.models.ProductCategory;

public class ProductService {

	private IProductDAO productDAO;
	private ProductCategoryService categoryService;
	
	public ProductService() {
		productDAO =  MyConnectionFactory.getProductMapper();
		categoryService = new ProductCategoryService();
	}
	
	public Product get(Long id){
		Product product = productDAO.get(id);
		product.setCategory(categoryService.getByProductId(product.getId()));
		return product;
	}
	
	public void insert(Product product) {
		productDAO.insert(product);
	}

	public List<Product> getAll() {
		List<Product> products = productDAO.getAll();
		products.forEach(x -> x.setCategory(categoryService.getByProductId(x.getId())));
		return products;
	}

	public void delete(Long id) {
		productDAO.delete(id);
	}

	public void update(Product product, Long id) {
		productDAO.update(product, id);
	}

	public Product getByOrderDetailId(Long id){
		Product product = productDAO.getByOrderDetailId(id);
		product.setCategory(categoryService.getByProductId(product.getId()));
		return product;
	}


}
