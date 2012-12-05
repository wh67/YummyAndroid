package com.intuitive.yummy;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SearchResultsActivity extends ListActivity {
	
	private String[] values = new String[] {
    		"Jack's Pizza", "Sally's Subs", "Bob's Burritos",
            "Larry's Lasagna", "Helga's Hell Kitchen", "Carlos' Cuisine", 
            "Isabel's Ice Cream" 
    };
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
