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
		
        InitializeSQLCipher(sqlkey);
		
        
	}
	
	   private void InitializeSQLCipher(String initKey) {
	        SQLiteDatabase.loadLibs(this);
	        File databaseFile = getDatabasePath("tasks.db");
	        databaseFile.mkdirs();
	        databaseFile.delete();
	        SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(databaseFile, initKey, null);
	        database.execSQL("create table tasks(id integer primary key autoincrement, title text not null)");
	        database.execSQL("insert into tasks(title) values('Placeholder 1')");
	    }
	    
	   
}
