package com.intuitive.yummy;

import java.io.Serializable;

public class SpecialOffers implements Serializable {
	private MenuItem MenuItem;
	private double Price = 0;
	private int Duration = 0;
	
	//Set MenuItem on a Special Offer
	public void setMenuItem(MenuItem Item){
		this.MenuItem = Item;
	}
	
	//Set price of Special Offer
	public void setPrice(double price){
		this.Price = price;
	}
	
	//Set duration of Special Offer
	public void setDuration(int duration){
		this.Duration = duration;
	}
	
	//Return MenuItem of Special Offer
	public MenuItem getMenuItem(){
		return this.MenuItem;
	}
	
	//Return price of Special Offer
	public double getPrice(){
		return this.Price;
	}
	
	//Return duration of Special Offer
	public int getDuration(){
		return this.Duration;
	}
	
	//Constructor
	SpecialOffers(MenuItem Item, double price, int duration){
		this.MenuItem = Item;
		this.Price = price;
		this.Duration = duration;
	}
}
