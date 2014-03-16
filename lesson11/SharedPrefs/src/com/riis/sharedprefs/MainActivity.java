package com.riis.sharedprefs;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		PreferenceManager.setDefaultValues(this, R.xml.default_values, false);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		String API_KEY = prefs.getString("myKey","not found");
		
	    try {
        	  URL url = new URL("http://www.riis.com/" + API_KEY);
        	  HttpURLConnection con = (HttpURLConnection) url
        	    .openConnection();
        	  readStream(con.getInputStream());
        	  } catch (Exception e) {
        	  e.printStackTrace();
        	}
	    
	    
	}

	private void readStream(InputStream in) {
		// TODO Auto-generated method stub
		return;
	}
	

}

