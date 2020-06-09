package com.solvd.warehouseProject.models;

import java.util.List;

public class Route {
    private Long id;
    private Order order;
    private List<Warehouse> warehouses;

    public Route() {
    }

    public Route(Order order) {
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
