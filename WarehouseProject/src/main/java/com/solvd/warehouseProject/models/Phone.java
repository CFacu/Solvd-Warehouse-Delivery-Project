package com.solvd.warehouseProject.models;

public class Phone {
    private Long id;
    private Integer number;
    private String type;

    public Phone() {
    }

    public Phone(Integer number, String type) {
        this.number = number;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
