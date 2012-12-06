package com.intuitive.yummy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class VendorActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);
        Intent intent = getIntent();
        Vendor vendor = (Vendor)intent.getSerializableExtra("Vendor");
        
        String name = vendor.getName();
        String description = vendor.getDescription();
        //String address;
        String status;
        if (vendor.getStatus())
        	status = "Open";
        else
        	status = "Closed";
        String hourOfOperation = "";
    	for (int i = 0; i < 7; i++)
    	{
    		if (vendor.getHours() == null)
    			hourOfOperation = "Not Available";
    		else
    		{
	    		int temp1 = vendor.getHours()[i][0];
	    		int openHour = (int)Math.floor(temp1/100);
	    		int openMinute = temp1%100;
	    		int temp2 = vendor.getHours()[i][1];
	    		int closeHour = (int)Math.floor(temp2/100);
	    		int closeMinute = temp2%100;
	    		        		
	    		if (openHour == 0 && openMinute == 0 && closeHour == 0 && closeMinute == 0)
	    			hourOfOperation += "Closed";
	    		else
	    		{
	    			String time = Integer.toString(openHour) + ":";
	    			if (openMinute == 0)
	    				time += "00";
	    			else
	    				time += Integer.toString(openMinute);
	    			time += " - ";
	    			time += Integer.toString(closeHour) + ":";
	    			if (closeMinute == 0)
	    				time += "00";
	    			else
	    				time += Integer.toString(closeMinute);
	    			hourOfOperation += time;
	    		}
	    		if (i == 0)
	    		{
	    	        TextView mondayHour = (TextView) findViewById(R.id.mondayHour);
	    	        mondayHour.setText(hourOfOperation);
	    		}
	    		else if (i == 1)
	    		{
	    			TextView tuesdayHour = (TextView) findViewById(R.id.tuesdayHour);
	    	        tuesdayHour.setText(hourOfOperation);
	    		}
	    		else if (i == 2)
	    		{
	    			TextView wednesdayHour = (TextView) findViewById(R.id.wednesdayHour);
	    	        wednesdayHour.setText(hourOfOperation);
	    		}
	    		else if (i == 3)
	    		{
	    			TextView thursdayHour = (TextView) findViewById(R.id.thursdayHour);
	    	        thursdayHour.setText(hourOfOperation);
	    		}
	    		else if (i == 4)
	    		{
	    			TextView fridayHour = (TextView) findViewById(R.id.fridayHour);
	    	        fridayHour.setText(hourOfOperation);
	    		}
	    		else if (i == 5)
	    		{
	    			TextView saturdayHour = (TextView) findViewById(R.id.saturdayHour);
	    	        saturdayHour.setText(hourOfOperation);
	    		}
	    		else if (i == 6)
	    		{
	    			TextView sundayHour = (TextView) findViewById(R.id.sundayHour);
	    	        sundayHour.setText(hourOfOperation);
	    		}
	    		hourOfOperation = "";
	    	}
        }
        
        TextView vendorName = (TextView) findViewById(R.id.vendorName);
        vendorName.setText(name);
        TextView vendorDescription = (TextView) findViewById(R.id.vendorDescription);
        vendorDescription.setText(description);
        TextView vendorStatus = (TextView) findViewById(R.id.currentStatus);
        vendorStatus.setText(status); 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_vendor, menu);
        return true;
    }
}
