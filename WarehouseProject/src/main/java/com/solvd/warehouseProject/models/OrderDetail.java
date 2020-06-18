package com.solvd.warehouseProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

//added deliveredVolume, could also put deliveredQuantity, but that would require some more calculations
public class OrderDetail extends AbstractEntity {
    private Product product;
    private Integer quantity;
    private Double subtotalVolume;
    private Double subtotalPrice;
    private Double volumeToDeliver;

    public OrderDetail() {
    	this.volumeToDeliver = 0.0;
    }

    public OrderDetail(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        this.subtotalVolume = this.getProduct().getVolume() * this.quantity;
        this.subtotalPrice = this.getProduct().getPrice() * this.quantity;
        this.volumeToDeliver = this.subtotalVolume;
    }
    
    @JsonIgnore
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
    
    @JsonIgnore
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    @JsonIgnore
	public Double getSubtotalPrice() {
		return subtotalPrice;
	}

	public void setSubtotalPrice(Double subtotalPrice) {
		this.subtotalPrice = subtotalPrice;
	}
	
	 @JsonIgnore
	public Double getVolumeToDeliver() {
		return volumeToDeliver;
	}

	public void setVolumeToDeliver(Double volumeToDeliver) {
		this.volumeToDeliver = volumeToDeliver;
	}

	public void calculateSubtotalPrice() {
        this.subtotalPrice = quantity * product.getPrice();
    }

    public void calculateSubtotalVolume() {
        this.subtotalVolume = quantity * product.getVolume();
    }
}
