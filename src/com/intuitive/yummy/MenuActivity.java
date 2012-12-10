package com.intuitive.yummy;

import android.app.ListActivity;
import android.content.Intent;
//import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class MenuActivity extends ListActivity {
	private com.intuitive.yummy.Menu menu;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Intent intent = getIntent();
        menu = (com.intuitive.yummy.Menu)intent.getSerializableExtra("Menu");
        String[] menuItemsName;
        if (menu.getMenuItem().size() == 0)
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
}
