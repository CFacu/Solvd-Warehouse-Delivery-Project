package com.solvd.warehouseProject.models;


public class Deposit extends AbstractEntity{
	private Warehouse warehouse;
	private OrderDetail orderDetail;
	private Double volumeDeposited;
	
	public Deposit () {}

	public Deposit(Warehouse warehouse, OrderDetail orderDetail, Double volumeDeposited) {
		this.warehouse = warehouse;
		this.orderDetail = orderDetail;
		this.volumeDeposited = volumeDeposited;
	}
	
	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	public Double getVolumeDeposited() {
		return volumeDeposited;
	}

	public void setVolumeDeposited(Double volumeDeposited) {
		this.volumeDeposited = volumeDeposited;
	}

	@Override
	public String toString() {
		return "Deposit [warehouse=" + warehouse.getName() + ", Product=" + orderDetail.getProduct().getName() + ", volumeDeposited="
				+ volumeDeposited + "]";
	}
	
	
}
