package com.intuitive.yummy;

import java.io.Serializable;

public class Vendor implements Serializable {
	private String name;
	private String description;
	private String address;
	private int[][] hours;
	private boolean status;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setHours(int[][] hours) {
		this.hours = hours;
	}
	public void openTruck() {
		status = true;
	}
	public void closeTruck() {
		status = false;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getAddress() {
		return address;
	}
	public int[][] getHours() {
		return hours;
	}
	public boolean getStatus() {
		return status;
	}
	
	//constructor
	Vendor (String name, String description, String address, int[][] hours, boolean status) {
		this.name = name;
		this.description = description;
		this.address = address;
		this.hours = hours;
		this.status = status;
	}
}
