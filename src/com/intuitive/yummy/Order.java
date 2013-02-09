package com.intuitive.yummy;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
	private int ID = 0;
	private int Duration = 0;  
	private ArrayList<MenuItem> Item = new ArrayList<MenuItem>();
	private double TotalPrice = 0;
	private enum Status {
        Cancelled, InProgress, Finished   
	}
	private Status status;
	
	//Set the wait time of the order
	public void setWaitingTime(int orderTime){
		Duration = orderTime;
	}
	
	//Return the order ID
	public int getOrderIdNumber(){
		return ID;
	}
	
	//Return how long the order will take
	public int getDuration(){
		return Duration;
	}
	
	//Return the status of the order
	public Status getStatus(){
		return status;
	}
	
	//Return the items of the order
	public ArrayList<MenuItem> getOrderItems(){
		return Item;
	}
		
	//Return the total price of the order
	public double getTotalOrderPrice(){
		return TotalPrice;
	}
	
	//Constructor
	Order(int id, int duration, Status stat,ArrayList<MenuItem> item, double totalPrice){
		ID = id;
		Duration = duration;
		status = stat;
		Item = item;
		TotalPrice = totalPrice;
		
	}
}
