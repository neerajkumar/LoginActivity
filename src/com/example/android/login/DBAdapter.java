package com.example.android.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {
	private SQLiteDatabase sqlDB;

	private DatabaseHelper dbHelper;
	
	private static final String DATABASE_NAME="db";
	public static final String USERNAME="username";
	public static final String PASSWORD="password";

	public DBAdapter(Context context) {
		dbHelper = new DatabaseHelper(context);
	}

	// Opens the database
	public DBAdapter open() throws SQLException {
		sqlDB = dbHelper.getWritableDatabase();
		return this;
	}

	// Closes the database
	public void close() {
		dbHelper.close();
	}
	
	public int insertRecord(ContentValues cv, String username, String password){
		cv.put(USERNAME, username);
		cv.put(PASSWORD, password);
		sqlDB.insert("users", USERNAME, cv);
		return 0;
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {

		/**
		 * @param context
		 * @param name
		 * @param factory
		 * @param version
		 */
		public DatabaseHelper(Context context) {
			super(context, "login.db", null, 1);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * android.database.sqlite.SQLiteOpenHelper#onCreate(android.database
		 * .sqlite.SQLiteDatabase)
		 */
		@Override
		public void onCreate(SQLiteDatabase sqlDB) {
			sqlDB
					.execSQL("CREATE TABLE users (_id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT);");
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database
		 * .sqlite.SQLiteDatabase, int, int)
		 */
		@Override
		public void onUpgrade(SQLiteDatabase sqlDB, int oldVersion,
				int newVersion) {

		}

	}
}
