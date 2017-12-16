package com.sutema.apps.alumnitracker;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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

    public void openMapsActivity (View view) {
        //untuk memanggil MapsActivity
        Intent myIntent3 = new Intent(this, MapsActivity.class);
        startActivity(myIntent3);
    }

    public void openProfile(View view){
        Intent intent = new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }

    public void signUp(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    LocationManager locationManager;
    LocationListener locationListener;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //test comment
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //agar dapat menjalankan location service
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {

                Log.i("Location", location.toString());

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            //ask for permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

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

}
