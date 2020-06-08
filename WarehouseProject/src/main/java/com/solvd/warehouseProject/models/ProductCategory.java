package com.solvd.warehouseProject.models;

public class ProductCategory {
    private Long id;
    private String name;
    private String description;
    private Product product;

    public ProductCategory() {
    }

    public ProductCategory(String name, String description, Product product) {
        this.name = name;
        this.description = description;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
