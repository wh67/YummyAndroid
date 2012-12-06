package com.intuitive.yummy;

import java.util.ArrayList;

//Contain menu information includes a list of menu items

public class Menu {
	private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	
	public void setMenu(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	public void addMenuItem(MenuItem menuItem) {
		menuItems.add(menuItem);
	}
	public void removeMenuItem(MenuItem menuItem) {
		menuItems.remove(menuItem);
	}
	public ArrayList<MenuItem> getMenu() {
		return menuItems;
	}
	
	Menu(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

}
