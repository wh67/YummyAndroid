package com.intuitive.yummy;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
	
	private ArrayList<MenuItem> Items = new ArrayList<MenuItem>();
	private double totalprice = 0;
	private boolean IsSure = false;
	
	//Set the array of items in the cart
	public void setItems(ArrayList<MenuItem> Item){
		this.Items = Item;
	}
	
	//Set the total price of all items
	public void setTotalPrice(ArrayList<MenuItem> Item, double price){
		for(int i = 0; i < Item.size(); i++){
			price += Item.get(i).getPrice();
		}
		
		this.totalprice = price;
	}
	
	//Return the items in the cart
	public ArrayList<MenuItem> getItems(){
		return this.Items;
	}
	
	//Return individual item in the cart
	public double getPrice(MenuItem Item){
		double price = 0;
		int ItemPos = this.Items.lastIndexOf(Item);
		
		if(this.Items.get(ItemPos).getName() == Item.getName()){
			price = this.Items.get(ItemPos).getPrice();
		}
				
		return price;
	}
	
	//Return the total price
	public double getTotalPrice(){
		return this.totalprice;
	}
	
	//Add an item to the cart
	public void addItem(MenuItem Item){
		this.Items.add(Item);
	}
	
	//Remove an item from the cart
	public void removeItem(MenuItem Item){
		this.Items.remove(Item);
	}
	
	//Remove all items from the cart
	public void removeAllItems(boolean check){
		this.IsSure = check;
		if(this.IsSure == true){
			this.Items.clear();
		}
	}
	
	//Constructor
	Cart(ArrayList<MenuItem> Items, double Totalprice, Boolean IsSure){
		this.Items = Items;
		this.totalprice = Totalprice;
		this.IsSure = IsSure;
	}
}
