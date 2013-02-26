package com.intuitive.yummy;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View.OnClickListener;


public class MenuActivity extends ListActivity {
	private com.intuitive.yummy.Menu menu;
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Intent intent = getIntent();
        menu = (com.intuitive.yummy.Menu)intent.getSerializableExtra("Menu");
        String[] menuItemsName;
        if (menu == null)
        {
        	menuItemsName = new String[1];
        	menuItemsName[0] = "No menu available.";
        }
        else if (menu.getMenuItem().size() == 0)
        {
        	menuItemsName = new String[1];
        	menuItemsName[0] = "No item available.";
        }
        else
        {
        	menuItemsName = new String[menu.getMenuItem().size()];
	        for (int i = 0; i < menu.getMenuItem().size(); i++)
	        {
	        	menuItemsName[i] = menu.getMenuItem().get(i).getName();
	        }
        }
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, menuItemsName);
        setListAdapter(adapter);
   
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_search_results, menu);
        return true;
    }
    
    public void cart(View v){
    	Intent intent = new Intent(this, CartActivity.class);
    	startActivity(intent);
    }
    
}
