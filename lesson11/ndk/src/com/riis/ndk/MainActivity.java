package com.riis.ndk;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;

public class MainActivity extends Activity {

    static {
	    System.loadLibrary("ndk");
	}
	
    private native String invokeNativeFunction();
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		      
        String apikey = invokeNativeFunction();
		new AlertDialog.Builder(this).setMessage(apikey).show();
		
	     try {
       	  URL url = new URL("http://www.riis.com/" + apikey );
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