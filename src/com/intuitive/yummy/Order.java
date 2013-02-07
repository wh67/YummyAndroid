package com.intuitive.yummy;

import java.io.Serializable;

public class Order implements Serializable {
	private int ID = 0;
	private int Duration = 0;
	private String Status;
	
	//Set status of the order
	public void setStatus(String stat){
		if (stat == "C") {
			this.Status = "Cancelled";
		}
		else if (stat == "IP"){
			this.Status = "InProgress";
		}
		else if (stat == "F"){
			this.Status = "Finished";
		}
		else {
			this.Status = "Set Status";
		}
	}
	
	//Set the wait time of the order
	public void setWaitingTime(int orderTime){
		this.Duration = orderTime;
	}
	
	//Return the order ID
	public int getOrderIdNumber(){
		return this.ID;
	}
	
	//Return how long the order will take
	public int getDuration(){
		return this.Duration;
	}
	
	//Return the status of the order
	public String getStatus(){
		return this.Status;
	}
	
	//Constructor
	Order(int id, int duration, String status){
		this.ID = id;
		this.Duration = duration;
		this.Status = status;
	}
}
