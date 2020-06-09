package com.solvd.warehouseProject.models;

public class OrderDetail extends AbstractEntity{
    private Product product;
    private Integer quantity;
    private Double totalVolume;
    private Double totalPrice;

    public OrderDetail() {
    }

    public OrderDetail(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
