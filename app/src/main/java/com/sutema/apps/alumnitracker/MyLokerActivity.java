package com.sutema.apps.alumnitracker;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Date;

public class MyLokerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_loker);

        FloatingActionButton createLokerBtn = findViewById(R.id.floatingActionButton);
        createLokerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLokerForm();
            }
        });

    }

    public void openLokerForm(){
        Intent intent = new Intent(this, LokerFormActivity.class);
        startActivity(intent);
    }
}
