package com.example.contactlist;

import android.app.ListActivity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class ContactList extends ListActivity implements OnItemClickListener {
	
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
        String[] projection = new String[] { People._ID, People.NAME };
        Cursor cursor = managedQuery(People.CONTENT_URI, projection, null, null, People.NAME + " ASC");
        
        ListAdapter adapter = new SimpleCursorAdapter(
        	this,
        	android.R.layout.two_line_list_item,
        	cursor,
        	new String[] { People._ID, People.NAME },
        	new int[] { android.R.id.text1, android.R.id.text2 }
        );
        setListAdapter(adapter);
        
        getListView().setOnItemClickListener(this);
        
        
    }

	public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
		
		Uri contactUri = ContentUris.withAppendedId(People.CONTENT_URI, id);
		Intent intent = new Intent(this, ContactDetails.class);
		intent.setData(contactUri);
		startActivity(intent);
		
	}
    
}