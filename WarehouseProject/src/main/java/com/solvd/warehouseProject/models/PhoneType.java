package com.solvd.warehouseProject.models;

public class PhoneType extends AbstractEntity{
	private String name;
	
	public PhoneType() {}

	public PhoneType (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
