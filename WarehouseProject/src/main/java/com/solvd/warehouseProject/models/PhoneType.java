package com.solvd.warehouseProject.models;

public class PhoneType {
	private Long id;
	private String name;
	
	public PhoneType() {}
	
	public PhoneType (Long id, String name) {
		this.id = id;
		this.name = name;
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
}
