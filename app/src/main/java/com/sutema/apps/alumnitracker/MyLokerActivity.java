package com.sutema.apps.alumnitracker;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class MyLokerActivity extends AppCompatActivity {

    private TextView notifTxt;
    private ImageView emptyIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_loker);

        notifTxt = findViewById(R.id.textView3);

        AppDatabase appDatabase = null;
        try {
            appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "sutema.db").allowMainThreadQueries().build();
            appDatabase.beginTransaction();

            Loker[] listLoker = appDatabase.lokerDAO().loadAllLokers();

            if (listLoker.length > 0){
                emptyIcon.setVisibility(View.INVISIBLE);
                notifTxt.setVisibility(View.INVISIBLE);
            }else{
                notifTxt.setText("List kosong cuy!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


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
