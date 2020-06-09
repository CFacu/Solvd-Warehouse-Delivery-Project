package com.solvd.warehouseProject.models;

public class OrderDetail {
    private Long id;
    private Product product;
    private Integer quantity;
    private Double totalVolume;

    public OrderDetail() {
    }

    public OrderDetail(Double totalVolume, Producto product, Integer quantity) {
        this.totalVolume = totalVolume;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
