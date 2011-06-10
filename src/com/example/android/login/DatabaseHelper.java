package com.example.android.login;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME="db";
	public static final String USERNAME="username";
	public static final String PASSWORD="password";
	SQLiteDatabase db;
	
	public DatabaseHelper(Context context){
		super(context, DATABASE_NAME, null, 1);
//		db.execSQL("CREATE TABLE users (_id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT);");		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE users (_id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT);");
	}

	public int insertRecord(ContentValues cv, String username, String password){
		cv.put(USERNAME, username);
		cv.put(PASSWORD, password);
		db.insert("users", USERNAME, cv);
		return 0;
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		android.util.Log.w("Constants", "Upgrading database, which will destroy all old data");
	    db.execSQL("DROP TABLE IF EXISTS users");
	    onCreate(db);
	}
	
	 
}
