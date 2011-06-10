package com.example.android.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements View.OnClickListener{
	Button btn;
	EditText username;
	EditText password;
	DatabaseHelper dbHelper;
	
    /** Called when the activity is first created. 
     * @param Context */
    public void onCreate(Bundle icicle) {
    	super.onCreate(icicle);
        setContentView(R.layout.main);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        btn=(Button)findViewById(R.id.login);
        btn.setOnClickListener(this);
        Context context = null;
       
    }

	@Override
	public void onClick(View v) {
		if (v==btn){
			ContentValues cv=new ContentValues();
			DBAdapter adapter = new DBAdapter(this);
			adapter.open();
			adapter.insertRecord(cv, username.getText().toString(), password.getText().toString());
			adapter.close();
			
			new AlertDialog.Builder(this).setTitle("Message Box").
			setMessage(username.getText().toString() + " " + password.getText().toString()).
			setNeutralButton("Close", new DialogInterface.OnClickListener() {
		          public void onClick(DialogInterface dlg, int sumthin) {
		            // do nothing - it will close on its own
		          }
		        }).
			show();
		}
	}
}
    

