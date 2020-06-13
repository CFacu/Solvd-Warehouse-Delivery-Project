package com.solvd.warehouseProject.models;

import java.time.LocalDate;

public class Product extends AbstractEntity{
    private String name;
    private String description;
    private Double volume;
    private LocalDate dueDate;
    private Double price;
    private ProductCategory category;
    private Integer daysUntilDueDate;

    public Product() {
    }

    public Product(String name, String description, Double volume, LocalDate dueDate, Double price, ProductCategory category) {
        this.name = name;
        this.description = description;
        this.volume = volume;
        this.dueDate = dueDate;
        this.price = price;
        this.category = category;
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

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return category;
    }

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public Integer getDaysUntilDueDate() {
		return daysUntilDueDate;
	}

	public void setDaysUntilDueDate(Integer daysUntilDueDate) {
		this.daysUntilDueDate = daysUntilDueDate;
	}
}
