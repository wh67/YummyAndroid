package com.intuitive.yummy;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SearchResultsActivity extends ListActivity {
	
	private String [] values = new String[7];
	/*
	private String[] values = new String[] {
    		"Jack's Pizza", "Sally's Subs", "Bob's Burritos",
            "Larry's Lasagna", "Helga's Hell Kitchen", "Carlos' Cuisine", 
            "Isabel's Ice Cream" 
    };
    */
	
	private Vendor[] vendors = {new Vendor("Jack's Pizza", "We sell Pizzas!", "", new int[][] {{830,1700}, {830,1700}, {830,1700}, {830,1700}, {830,1700}, {0,0}, {0,0}}, false),
						new Vendor("Sally's Subs", "", "",  new int[][] {{830,1700}, {830,1700}, {830,1700}, {830,1700}, {830,1700}, {0,0}, {0,0}}, false),
						new Vendor("Bob's Burritos", "", "",  new int[][] {{830,1700}, {830,1700}, {830,1700}, {830,1700}, {830,1700}, {0,0}, {0,0}}, false),
						new Vendor("Larry's Lasagna", "", "",  new int[][] {{830,1700}, {830,1700}, {830,1700}, {830,1700}, {830,1700}, {0,0}, {0,0}}, false),
						new Vendor("Helga's Hell Kitchen", "", "",  new int[][] {{830,1700}, {830,1700}, {830,1700}, {830,1700}, {830,1700}, {0,0}, {0,0}}, false),
						new Vendor("Carlos' Cuisine", "", "",  new int[][] {{830,1700}, {830,1700}, {830,1700}, {830,1700}, {830,1700}, {0,0}, {0,0}}, false),
						new Vendor("Isabel's Ice Cream", "We love Ice Cream!", "",  new int[][] {{830,1700}, {830,1700}, {830,1700}, {830,1700}, {830,1700}, {900,1800}, {900,1800}}, false)};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	for (int i = 0; i < vendors.length; i++)
    	{
    		values[i] = vendors[i].getName();
    	}
    	
        super.onCreate(savedInstanceState);
        
        Intent intent = getIntent();
        
        if(intent.getStringExtra("criteria").equals("nearby")){
        	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        			android.R.layout.simple_list_item_1, values);
            setListAdapter(adapter);
        }       
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_search_results, menu);
        return true;
    }
    
    /*
    protected void onListItemClick(ListView lv, View v, int position, long id){
    	super.onListItemClick(lv, v, position, id);
    	Intent intent = new Intent(this, VendorActivity.class);
    	startActivity(intent);
    	
    }
    */
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	Vendor vendor = vendors[position];
    	Intent intent = new Intent(this, VendorActivity.class);
    	intent.putExtra("Vendor", vendor);
    	startActivity(intent);
    }
    
}
