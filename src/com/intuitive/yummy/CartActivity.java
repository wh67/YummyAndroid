package com.intuitive.yummy;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class CartActivity extends Activity {

	String[] addedItems = {"16 inch Cheese Pizza", "16 inch Pepperoni Pizza", "16 inch Sausage Pizza", "Cheese Pizza Slice"};
	double[] price = {14.99, 16.99, 16.99, 2.99};
	TableLayout t1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart);
		t1 = (TableLayout)findViewById(R.id.table1);
		
		for (int i = 0; i < addedItems.length; i++){
			TableRow tr = new TableRow(this);
			TextView tv1 = new TextView(this);
			TextView tv2 = new TextView(this);
			TextView tv3 = new TextView(this);
			
			createView(tr,tv1,Integer.toString(1));
			createView(tr,tv2,addedItems[i]);
			createView(tr,tv3,Double.toString(price[i]));
			t1.addView(tr);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_cart, menu);
		return true;
	}

public void createView(TableRow tr, TextView t, String viewdata) {
	t.setText(viewdata);
	//adjust the properties of the textView
	t.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
	t.setTextColor(Color.WHITE);
	t.setBackgroundColor(Color.BLACK);
	t.setPadding(20, 0, 0, 0);
	tr.setPadding(0, 1, 0, 1);
	tr.setBackgroundColor(Color.WHITE);
	tr.addView(t); // add TextView to row.
	}

}
