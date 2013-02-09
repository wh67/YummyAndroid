package com.intuitive.yummy;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
	
	private ArrayList<MenuItem> Items = new ArrayList<MenuItem>();
	private double totalprice = 0;
	
	//Set the array of items in the cart
	public void setItems(ArrayList<MenuItem> Item){
		Items = Item;
	}
	
	//Update the total price of all items
	private void updateTotalPrice() {
		totalprice = 0;
		
		for (int i = 0; i < Items.size(); i++) {
			totalprice += Items.get(i).getPrice();
		}
	}
	
	//Return the items in the cart
	public ArrayList<MenuItem> getItems(){
		return Items;
	}
	
	//Return the total price
	public double getTotalPrice(){
		return totalprice;
	}
	
	//Add an item to the cart
	public void addItem(MenuItem Item){
		Items.add(Item);
		updateTotalPrice();
	}
	
	//Remove an item from the cart
	public void removeItem(MenuItem Item){
		Items.remove(Item);
		updateTotalPrice();
	}
	
	//Remove all items from the cart
	public void removeAllItems(){
		Items.clear();
		updateTotalPrice();
	}
	
	//Constructor
	Cart(ArrayList<MenuItem> Item, double Totalprice){
		Items = Item;
		totalprice = Totalprice;
	}
}
