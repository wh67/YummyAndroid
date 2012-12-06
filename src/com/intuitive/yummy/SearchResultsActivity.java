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
	
	//dummy data for vendors
	private Vendor[] vendors = {
			new Vendor("Jack's Pizza", "We sell Pizzas!", "", new int[][] {{830,1700}, {830,1700}, {830,1700}, {830,1700}, {830,1700}, {0,0}, {0,0}}, false),
			new Vendor("Sally's Subs", "Welcome to Sally's Subs", "",  new int[][] {{830,1800}, {830,1800}, {830,1800}, {830,1800}, {830,1800}, {0,0}, {0,0}}, false),
			new Vendor("Bob's Burritos", "Hello from Bob's Burritos", "",  new int[][] {{900,1700}, {900,1700}, {900,1700}, {900,1700}, {900,1700}, {900,1900}, {900,1900}}, false),
			new Vendor("Larry's Lasagna", "Welcome to Bob's Burritos", "",  new int[][] {{800,1700}, {800,1700}, {800,1700}, {800,1700}, {800,1700}, {800,2000}, {800,2000}}, false),
			new Vendor("Helga's Hell Kitchen", "Hello from Helga's Hell Kitchen", "",  new int[][] {{830,1700}, {830,1700}, {830,1700}, {830,1700}, {830,1700}, {900,1800}, {0,0}}, false),
			new Vendor("Carlos' Cuisine", "Welcome to Carlos' Cuisine", "",  new int[][] {{0,0}, {830,1700}, {830,1700}, {830,1700}, {830,1700}, {830,1700}, {830,1700}}, false),
			new Vendor("Isabel's Ice Cream", "Isabel's Ice Cream\nThe Best Ice Cream In The World", "",  new int[][] {{830,1700}, {830,1700}, {830,1700}, {830,1700}, {830,1700}, {900,1800}, {900,1800}}, false)
			};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	//Get the list of vendor and create a array of vendors by name only
    	//then pass it to the list adapter to display it as a list in the app
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
    
    //get the correspond vendor and pass it to the VendorActivity
    protected void onListItemClick(ListView lv, View v, int position, long id){
    	Vendor vendor = vendors[position];
    	Intent intent = new Intent(this, VendorActivity.class);
    	intent.putExtra("Vendor", vendor);
    	startActivity(intent);
    	
    }
    
}
