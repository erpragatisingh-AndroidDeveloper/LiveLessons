package com.riis.sqlndk;

import java.io.File;

import net.sqlcipher.database.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;

public class MainActivity extends Activity {

    static {
	    System.loadLibrary("sqlndk");
	}
	
    private native String invokeNativeFunction();
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		      
        String sqlkey = invokeNativeFunction();
		new AlertDialog.Builder(this).setMessage(sqlkey).show();
		
		String apiKey = InitializeWebServices();
        InitializeSQLCipher(sqlkey, apiKey);
		
        
	}
	
	   private String InitializeWebServices() {
		// TODO call web services to receive apiKey
		return "W12345";
	}
	
	   private void InitializeSQLCipher(String initKey, String apiVal) {
	        SQLiteDatabase.loadLibs(this);
	        File databaseFile = getDatabasePath("secrets.db");
	        databaseFile.mkdirs();
	        databaseFile.delete();
	        SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(databaseFile, initKey, null);
	        database.execSQL("create table apikey(id integer primary key autoincrement, keys text not null)");
		    database.execSQL("insert into apikey(keys) values('" + apiVal + "')");
	    }
	    
	   
}
