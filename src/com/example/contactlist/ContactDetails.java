package com.example.contactlist;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.widget.TextView;

public class ContactDetails extends Activity {
	
	TextView nameField = null;
	TextView phoneField = null;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        
        nameField = (TextView) findViewById(R.id.contact_name);
        phoneField = (TextView) findViewById(R.id.contact_phone);
        
    }

	@Override
	protected void onStart() {
		
		super.onStart();
		
		Cursor cursor = managedQuery(getIntent().getData(), null, null, null, null);
		cursor.moveToFirst();
		
		nameField.setText(cursor.getString(cursor.getColumnIndex(People.NAME)));
		phoneField.setText(cursor.getString(cursor.getColumnIndex(People.NUMBER)));
		
	}

}
