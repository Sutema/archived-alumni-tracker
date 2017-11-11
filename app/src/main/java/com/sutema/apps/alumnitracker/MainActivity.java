package com.sutema.apps.alumnitracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //test comment
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Register(View view){
        //Klik Daftar
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
}
