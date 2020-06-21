package com.solvd.warehouseProject;

import com.solvd.warehouseProject.models.*;
import com.solvd.warehouseProject.parsers.JaxbParser;
import com.solvd.warehouseProject.services.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

	private final static Logger LOGGER = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {

		
		Company company = JaxbParser.jaxbXmlToObject(Company.class, "src/main/resources/jaxbxml/company.xml");
		
		Warehouse warehouse = company.getClosestWarehouse().getNextWarehouse();
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

		InsertData.insertCompanyIntoDB(company);
		company.deliverOrder(truck, order);
		}
}
