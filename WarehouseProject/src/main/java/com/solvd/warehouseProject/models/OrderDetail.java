package com.solvd.warehouseProject.models;

public class OrderDetail extends AbstractEntity{
    private Product product;
    private Integer quantity;
    private Double subtotalVolume;
    private Double subtotalPrice;

    public OrderDetail() {
    }

    public OrderDetail(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Double getSubtotalVolume() {
        return subtotalVolume;
    }

    public void setSubtotalVolume(Double subtotalVolume) {
        this.subtotalVolume = subtotalVolume;
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

	public Double getSubtotalPrice() {
		return subtotalPrice;
	}

	public void setSubtotalPrice(Double subtotalPrice) {
		this.subtotalPrice = subtotalPrice;
	}

	public void calculateSubtotalPrice() {
        this.subtotalPrice = quantity * product.getPrice();
    }

    public void calculateSubtotalVolume() {
        this.subtotalVolume = quantity * product.getVolume();
    }
}
