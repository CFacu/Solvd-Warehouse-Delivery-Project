package com.solvd.warehouseProject.models;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.warehouseProject.parsers.LocalDateAdapter;

@XmlRootElement (name = "product")
@XmlType(propOrder = { "name", "description", "volume", "dueDate", "price", "productCategory"})
public class Product extends AbstractEntity{
    private String name;
    private String description;
    private Double volume;
    private LocalDate dueDate;
    private Double price;
    private ProductCategory productCategory;
    private Integer daysUntilDueDate;

    public Product() {
    }

    public Product(String name, String description, Double volume, LocalDate dueDate, Double price, ProductCategory productCategory) {
        this.name = name;
        this.description = description;
        this.volume = volume;
        this.dueDate = dueDate;
        this.price = price;
        this.productCategory = productCategory;
    }
    
    @XmlElement(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @XmlElement(name="description")
    @JsonIgnore
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @XmlElement(name="volume")
    @JsonIgnore
    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }
    
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement(name="due_date")
    @JsonIgnore
    public LocalDate getDueDate() {
        return dueDate;
    }
    
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    
    @XmlElement(name="price")
    @JsonIgnore
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    @XmlElement(name="category")
    @JsonIgnore
    public ProductCategory getProductCategory() {
        return productCategory;
    }

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	
	@XmlTransient
	@JsonIgnore
	public Integer getDaysUntilDueDate() {
		return daysUntilDueDate;
	}

	public void setDaysUntilDueDate(Integer daysUntilDueDate) {
		this.daysUntilDueDate = daysUntilDueDate;
	}
}
