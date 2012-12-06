package com.intuitive.yummy;

import java.util.ArrayList;

//includes menu item information, includes their ingredients' information

public class MenuItem {
	private String name;
	private double price;
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setIngredient(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
	}
	public void removeIngredient(Ingredient ingredient) {
		ingredients.remove(ingredient);
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public ArrayList<Ingredient> getIngredient() {
		return ingredients;
	}
	
	MenuItem(String name, double price, ArrayList<Ingredient> ingredients) {
		this.name = name;
		this.price = price;
		this.ingredients = ingredients;
	}
	
}
