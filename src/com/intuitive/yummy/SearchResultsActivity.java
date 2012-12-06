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
	
	Vendor[] vendors = {new Vendor("Jack's Pizza", "", "", null, false),
						new Vendor("Sally's Subs", "", "", null, false),
						new Vendor("Bob's Burritos", "", "", null, false),
						new Vendor("Larry's Lasagna", "", "", null, false),
						new Vendor("Helga's Hell Kitchen", "", "", null, false),
						new Vendor("Carlos' Cuisine", "", "", null, false),
						new Vendor("Isabel's Ice Cream", "", "", null, false)};
	
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
    
    protected void onListItemClick(ListView lv, View v, int position, long id){
    	super.onListItemClick(lv, v, position, id);
    	Intent intent = new Intent(this, VendorActivity.class);
    	startActivity(intent);
    	
    }
    
}
