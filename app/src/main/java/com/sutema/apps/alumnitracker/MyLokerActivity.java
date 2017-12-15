package com.sutema.apps.alumnitracker;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyLokerActivity extends AppCompatActivity {

    private TextView notifTxt;
    private ImageView emptyIcon;
    private TextView progressTxt;
    private Loker[] myLokerList;
    DbSingleton dbSingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_loker);

        dbSingleton = DbSingleton.getInstance(this);

        notifTxt = findViewById(R.id.textView3);
        progressTxt = findViewById(R.id.textView6);

        FetchLoker fetchLoker = new FetchLoker();
        fetchLoker.execute();

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
    public class FetchLoker extends AsyncTask<Void, Integer, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            notifTxt.setText("Pre Execute State");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try{
                if (myLokerList.length == 0){
                    notifTxt.setText("No Loker Submitted yet...");
                }else{
                    notifTxt.setText("Download complete");
                }
            }catch (Exception e){
                Log.e("MyLokerAct",e.getMessage());
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressTxt.setText(values[0]+"% completed...");
        }

        @Override
        protected String doInBackground(Void... voids) {
            try{
                myLokerList = dbSingleton.appDatabase.lokerDAO().loadAllLokers();
            }catch (Exception e){
                Log.e("MyLokerActivity",e.getMessage());
            }
            return null;
        }
    }
}




