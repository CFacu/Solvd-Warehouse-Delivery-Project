package com.solvd.warehouseProject.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement (name = "order_detail")
@XmlType(propOrder = { "product", "quantity"})
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
    
    @XmlTransient
    @JsonIgnore
    public Double getSubtotalVolume() {
        return subtotalVolume;
    }

    public void setSubtotalVolume(Double subtotalVolume) {
        this.subtotalVolume = subtotalVolume;
    }
    
    @XmlElement(name="product")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    @XmlElement(name="quantity")
    @JsonIgnore
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    @XmlTransient
    @JsonIgnore
	public Double getSubtotalPrice() {
		return subtotalPrice;
	}

	public void setSubtotalPrice(Double subtotalPrice) {
		this.subtotalPrice = subtotalPrice;
	}
	
	@XmlTransient
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

	@Override
	public String toString() {
		return "OrderDetail [product=" + product + ", quantity=" + quantity + ", subtotalVolume=" + subtotalVolume
				+ ", subtotalPrice=" + subtotalPrice + ", volumeToDeliver=" + volumeToDeliver + "]";
	}
}
