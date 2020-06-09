package com.solvd.warehouseProject.models;

import java.util.List;

public class Route extends AbstractEntity{
    private Order order;
    private List<Warehouse> warehouses;

    public Route() {
    }

    public Route(Order order) {
        this.order = order;
    }

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}
}
