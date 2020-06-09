package com.solvd.warehouseProject.models;

public class Location {
    private Long id;
    private String street;
    private String number;
    private String code;
    private Warehouse warehouse;

    public Location() {
    }

    public Location(String street, String number, String code, Warehouse warehouse) {
        this.street = street;
        this.number = number;
        this.code = code;
        this.warehouse = warehouse;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
