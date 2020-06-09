package com.solvd.warehouseProject.models;

public class Phone extends AbstractEntity{
    private String number;
    private PhoneType type;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

}
