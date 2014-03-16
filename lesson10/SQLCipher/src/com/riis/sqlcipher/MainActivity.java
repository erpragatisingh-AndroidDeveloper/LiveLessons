package com.riis.sqlcipher;

import java.io.File;

import net.sqlcipher.database.SQLiteDatabase;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        InitializeSQLCipher();
    }
    
    private void InitializeSQLCipher() {
        SQLiteDatabase.loadLibs(this);
        File databaseFile = getDatabasePath("tasks.db");
        databaseFile.mkdirs();
        databaseFile.delete();
        SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(databaseFile, "test123", null);
        database.execSQL("create table tasks(id integer primary key autoincrement, title text not null)");
        database.execSQL("insert into tasks(title) values('Placeholder 1')");
    }
    
}
