package com.sutema.apps.alumnitracker;

import android.content.Intent;
<<<<<<< HEAD
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
=======
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

>>>>>>> 9fc098b73b5eb66c7698be6d6f8d0d60c4efc050

public class MainActivity extends AppCompatActivity {

    public void openLoginActivity(View view) {

        //untuk memanggil login page
        Intent myIntent = new Intent(this, LoginActivity.class);
        startActivity(myIntent);

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

<<<<<<< HEAD
    public void Register(View view){
        //Klik Daftar
        Intent intent = new Intent(this, SignupActivity.class);
=======
    public void openProfile(View view){
        Intent intent = new Intent(this, UserProfileActivity.class);
>>>>>>> 9fc098b73b5eb66c7698be6d6f8d0d60c4efc050
        startActivity(intent);
    }
}
