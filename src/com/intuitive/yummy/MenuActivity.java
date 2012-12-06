package com.intuitive.yummy;

import android.app.ListActivity;
//import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class MenuActivity extends ListActivity {

	private String[] values = new String[] {
			"16 inch Cheese Pizza", 
            "16 inch Pepperoni Pizza", 
            "16 inch Sausage Pizza",
			"Cheese Pizza Slice",
    		"Pepperoni Pizza Slice", 
    		"Sausage Pizza Slice",
            "Pizza Cheesteak",
            "Chicken Cheesteak",
            "Pepsi 2 liter",
            "Coca-Cola 2 liter"
    };
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Intent intent = getIntent();
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_search_results, menu);
        return true;
    }
}
