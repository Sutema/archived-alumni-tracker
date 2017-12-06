package com.sutema.apps.alumnitracker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    public void openLoginActivity(View view) {

        //untuk memanggil login page
        Intent myIntent = new Intent(this, LoginActivity.class);
        startActivity(myIntent);

    }

    public void openJSONDemoActivity (View view) {

        //untuk memanggil JSONDemo
        Intent myIntent2 = new Intent(this, JSONDemoActivity.class);
        startActivity(myIntent2);
    }

    public void signUpAttempt (View view) {

        //fungsi sementara untuk insert data ke db
        try {
            //inisiasi create database
            SQLiteDatabase testDb = this.openOrCreateDatabase("TestDb", MODE_PRIVATE, null);

            //sql create tabel dan insert
            testDb.execSQL("CREATE TABLE IF NOT EXISTS users (username VARCHAR, password VARCHAR)");
            testDb.execSQL("INSERT INTO users (username, password) VALUES ('adminU1','adminP1')");

            //masih kurang paham
            Cursor c = testDb.rawQuery("SELECT * FROM users", null);

            //untuk sqlite, semua kolom memilik index
            int usernameIndex = c.getColumnIndex("username");
            int passwordIndex = c.getColumnIndex("password");

            //logic while
            c.moveToFirst();
            while (c != null) {

                Log.i("Result username", c.getString(usernameIndex));
                Log.i("Result password", c.getString(passwordIndex));

                c.moveToNext();

            }
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //test comment
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openProfile(View view){
        Intent intent = new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }

    public void signUp(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
}
