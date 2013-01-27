package com.intuitive.yummy;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends Activity {
	Button cancel;
	TextView required1, required2, required3, required4, required5, required6, required7;
	EditText username, password1, password2, firstname, lastname, phone, email;
	Pattern pattern;
	Matcher matcher;
	final String USERNAME_PATTERN = "((?=.*[a-z]).{8,20})";
	final String PASSWORD_PATTERN = "((?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,20})";
	final String NAME_PATTERN = "[^0-9]*";
	final String PHONE_PATTERN = "^(\\d{3}-{1}\\d{3}-{1}\\d{4})$";
	final String EMAIL_PATTERN = "^[A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		required1 = (TextView)findViewById(R.id.required1);
		required1.setTextColor(Color.parseColor("#FF0000"));
		required1.setVisibility(TextView.INVISIBLE);
		required2 = (TextView)findViewById(R.id.required2);
		required2.setTextColor(Color.parseColor("#FF0000"));
		required2.setVisibility(TextView.INVISIBLE);
		required3 = (TextView)findViewById(R.id.required3);
		required3.setTextColor(Color.parseColor("#FF0000"));
		required3.setVisibility(TextView.INVISIBLE);
		required4 = (TextView)findViewById(R.id.required4);
		required4.setTextColor(Color.parseColor("#FF0000"));
		required4.setVisibility(TextView.INVISIBLE);
		required5 = (TextView)findViewById(R.id.required5);
		required5.setTextColor(Color.parseColor("#FF0000"));
		required5.setVisibility(TextView.INVISIBLE);
		required6 = (TextView)findViewById(R.id.required6);
		required6.setTextColor(Color.parseColor("#FF0000"));
		required6.setVisibility(TextView.INVISIBLE);
		required7 = (TextView)findViewById(R.id.required7);
		required7.setTextColor(Color.parseColor("#FF0000"));
		required7.setVisibility(TextView.INVISIBLE);
		
		username = (EditText)findViewById(R.id.username_field);
		password1 = (EditText)findViewById(R.id.password_field);
		password2 = (EditText)findViewById(R.id.reenter_password_field);
		firstname = (EditText)findViewById(R.id.firstname_field);
		lastname = (EditText)findViewById(R.id.lastname_field);
		phone = (EditText)findViewById(R.id.phone_field);
		email = (EditText)findViewById(R.id.email_field);
		
		cancel = (Button)findViewById(R.id.button_register_cancel);
        cancel.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_register, menu);
		return true;
	}
	
	public void checkRegistration(View v) {
		resetCheck();

		if (!checkAllCompleted()) {
    		Toast.makeText(getApplicationContext(), "Please Complete All Fields Marked by *", Toast.LENGTH_LONG).show();
		} else if (!checkValidUsername()) {
			required1.setVisibility(TextView.VISIBLE);
    		Toast.makeText(getApplicationContext(), "Username Must Be Between 8 to 20 Characters and Must Contain At Least 1 Letter", Toast.LENGTH_LONG).show();
		} else if (!checkValidPassword()) {
			required2.setVisibility(TextView.VISIBLE);
    		Toast.makeText(getApplicationContext(), "Password Must Be Between 8 to 20 Characters and Must Contain At Least 1 Uppercase, 1 Lowercase, and 1 Number", Toast.LENGTH_LONG).show();
		} else if (!checkPasswordMatch()) {
			required2.setVisibility(TextView.VISIBLE);
			required3.setVisibility(TextView.VISIBLE);
    		Toast.makeText(getApplicationContext(), "Password Mis-Match, Please Re-Enter", Toast.LENGTH_LONG).show();
		} else if (!checkValidFirstname()) {
			required4.setVisibility(TextView.VISIBLE);
    		Toast.makeText(getApplicationContext(), "Firstname Cannot Include Numbers", Toast.LENGTH_LONG).show();
		} else if (!checkValidLastname()) {
			required5.setVisibility(TextView.VISIBLE);
    		Toast.makeText(getApplicationContext(), "Lastname Cannot Include Numbers", Toast.LENGTH_LONG).show();
		} else if (!checkValidPhone()) {
			required6.setVisibility(TextView.VISIBLE);
    		Toast.makeText(getApplicationContext(), "Phone Number in Wrong Format.  Please Follow The Format 123-456-7890", Toast.LENGTH_LONG).show();
		} else if (!checkValidEmail()) {
			required7.setVisibility(TextView.VISIBLE);
    		Toast.makeText(getApplicationContext(), "Email in Wrong Format.  Please Double Check", Toast.LENGTH_LONG).show();
		} else {
			//register
		}
	}
	
	private void resetCheck() {
		required1.setVisibility(TextView.INVISIBLE);
		required2.setVisibility(TextView.INVISIBLE);
		required3.setVisibility(TextView.INVISIBLE);
		required4.setVisibility(TextView.INVISIBLE);
		required5.setVisibility(TextView.INVISIBLE);
		required6.setVisibility(TextView.INVISIBLE);
		required7.setVisibility(TextView.INVISIBLE);
	}
	
	private boolean checkAllCompleted() {
		boolean allCompleted = true;
		if (username.getText().toString().isEmpty()) {
			allCompleted = false;
			required1.setVisibility(TextView.VISIBLE);
		}
		if (password1.getText().toString().isEmpty()) {
			allCompleted = false;
			required2.setVisibility(TextView.VISIBLE);
		}
		if (password2.getText().toString().isEmpty()) {
			allCompleted = false;
			required3.setVisibility(TextView.VISIBLE);
		}
		if (firstname.getText().toString().isEmpty()) {
			allCompleted = false;
			required4.setVisibility(TextView.VISIBLE);
		}
		if (lastname.getText().toString().isEmpty()) {
			allCompleted = false;
			required5.setVisibility(TextView.VISIBLE);
		}
		if (phone.getText().toString().isEmpty()) {
			allCompleted = false;
			required6.setVisibility(TextView.VISIBLE);
		}
		if (email.getText().toString().isEmpty()) {
			allCompleted = false;
			required7.setVisibility(TextView.VISIBLE);
		}
		return allCompleted;
	}
	
	private boolean checkValidUsername() {
		pattern = Pattern.compile(USERNAME_PATTERN);
		matcher = pattern.matcher(username.getText().toString());
		return matcher.matches();
	}

	private boolean checkValidPassword() {
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password1.getText().toString());
		return matcher.matches();
	}
	
	private boolean checkPasswordMatch() {
		return password1.getText().toString().equals(password2.getText().toString());
	}

	private boolean checkValidFirstname() {
		pattern = Pattern.compile(NAME_PATTERN);
		matcher = pattern.matcher(firstname.getText().toString());
		return matcher.matches();
	}
	
	private boolean checkValidLastname() {
		pattern = Pattern.compile(NAME_PATTERN);
		matcher = pattern.matcher(lastname.getText().toString());
		return matcher.matches();
	}
	
	private boolean checkValidPhone() {
		pattern = Pattern.compile(PHONE_PATTERN);
		matcher = pattern.matcher(phone.getText().toString());
		return matcher.matches();
	}
	
	private boolean checkValidEmail() {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email.getText().toString());
		return matcher.matches();
	}
	
}
