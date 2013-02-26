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
	private ListView listView;

		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        
        Intent intent = getIntent();
        menu = (com.intuitive.yummy.Menu)intent.getSerializableExtra("Menu");
        MenuItem[] itemsArray = new MenuItem[menu.getMenuItem().size()];
        menu.getMenuItem().toArray(itemsArray);
        
        System.out.println("creating adapter");
        MenuItemAdapter adapter = new MenuItemAdapter(this, R.layout.list_menuitem, itemsArray);
        listView = (ListView)findViewById(R.id.listMenuItem);
        listView.setAdapter(adapter);
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
