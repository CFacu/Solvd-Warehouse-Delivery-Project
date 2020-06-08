package com.solvd.warehouseProject.models;

public class OrderDetail {
    private Long id;
    private Double totalVolume;

    public OrderDetail() {
    }

    public OrderDetail(Double totalVolume) {
        this.totalVolume = totalVolume;
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
}
