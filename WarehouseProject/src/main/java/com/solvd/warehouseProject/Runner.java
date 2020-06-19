package com.solvd.warehouseProject;

import com.solvd.warehouseProject.models.*;
import com.solvd.warehouseProject.parsers.JaxbParser;
import com.solvd.warehouseProject.services.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

	private final static Logger LOGGER = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {
		CompanyService companyService = new CompanyService();
		WarehouseService warehouseService = new WarehouseService();
		TruckService truckService = new TruckService();
		OrderService orderService = new OrderService();
		OrderDetailService orderDetailService = new OrderDetailService();
		ProductService productService = new ProductService();
		DriverService driverService = new DriverService();
		PhoneService phoneService = new PhoneService();
		ProductCategoryService categoryService = new ProductCategoryService();
		
		Company company = JaxbParser.jaxbXmlToObject(Company.class, "src/main/resources/jaxbxml/company.xml");

		company.setClosestWarehouse(company.getWarehouses().get(0));
		
		Warehouse warehouse = company.getWarehouses().get(0).getNextWarehouse();
		while (warehouse != null) {
			company.getWarehouses().add(warehouse);
			warehouse = warehouse.getNextWarehouse();
		}
		
		Truck truck = company.getTrucks().get(0);
		
		Order order = truck.getOrders().get(0);
		
		order.getOrderDetails().forEach(od -> od.calculateSubtotalPrice());
		order.getOrderDetails().forEach(od -> od.calculateSubtotalVolume());
		order.calculateDaysUntilDueDate();
		
		order.getOrderDetails().forEach(od -> od.setVolumeToDeliver(od.getSubtotalVolume()));

		companyService.insert(company);
		company.getWarehouses().forEach(x -> {
			warehouseService.insert(x);
			warehouseService.addToCompany(company, x);
		});
		company.getTrucks().forEach(x -> {
			truckService.insert(x);
			truckService.addToCompany(company, x);
			x.getDrivers().forEach(z -> {
				driverService.insert(z);
				z.getPhones().forEach(v -> {
					phoneService.insert(v);
					phoneService.addToDriver(z, v);
				});
			});
			x.getOrders().forEach(z -> {
				orderService.insert(z);
				orderService.addToTruck(x, z);
				z.getOrderDetails().forEach(v -> {
					orderDetailService.insert(v);
					orderDetailService.addToOrder(v, z);
					productService.insert(v.getProduct());
					categoryService.insert(v.getProduct().getProductCategory());
				});
			});
		});

		company.deliverOrder(truck, order);
		}
}
