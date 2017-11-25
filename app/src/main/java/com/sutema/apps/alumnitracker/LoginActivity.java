package com.sutema.apps.alumnitracker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLClientInfoException;

public class LoginActivity extends AppCompatActivity {

    EditText usernameField;
    EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameField = (EditText) findViewById(R.id.username);
        passwordField = (EditText) findViewById(R.id.password);

    }

    public void loginAttempt (View view) {
        //hanya untuk menampilkan log apa yang diinput oleh user
        Log.i("AppInfo", String.valueOf(usernameField.getText()));
        Log.i("AppInfo", String.valueOf(passwordField.getText()));

        //menyimpan value dari inputan user
        String usernameValue = String.valueOf(usernameField.getText());
        String passwordValue = String.valueOf(passwordField.getText());

        try {

            //inisiasi koneksi db
            SQLiteDatabase testDb = this.openOrCreateDatabase("TestDb", MODE_PRIVATE, null);

            //query ke db
            Cursor c = testDb.rawQuery("SELECT * FROM users WHERE username = '"+usernameValue+"' AND password = '"+passwordValue+"'", null);

            //di sqlite kolom yang sudah diquery memiliki index
            int userIndex = c.getColumnIndex("username");
            int passIndex = c.getColumnIndex("password");

            //logic test
            if (c.getCount() == 1){
                Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
