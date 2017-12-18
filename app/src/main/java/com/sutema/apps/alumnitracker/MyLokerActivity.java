package com.sutema.apps.alumnitracker;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.EmptyStackException;

public class MyLokerActivity extends AppCompatActivity {

    private TextView notifTxt;
    private ImageView emptyIcon;
    private TextView progressTxt;
    private Loker[] myLokerList;
    private ListView lokerListView;
    DbSingleton dbSingleton;
    LokerAdapter lokerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_loker);

        dbSingleton = DbSingleton.getInstance(this);
        emptyIcon = findViewById(R.id.imageView2);
        notifTxt = findViewById(R.id.textView3);
        progressTxt = findViewById(R.id.textView6);
        lokerListView = findViewById(R.id.listview_loker);

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
            Log.i("onPostExecute","Executed!");
            try{
                if (myLokerList.length == 0){
                    notifTxt.setText("No Loker Submitted yet...");
                }else{
                    emptyIcon.setVisibility(View.INVISIBLE);
                    notifTxt.setVisibility(View.INVISIBLE);
                    lokerListView.setVisibility(View.VISIBLE);
                    renderLokerListView();
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

    public void renderLokerListView(){
        lokerAdapter = new LokerAdapter(this,R.layout.loker_row,myLokerList);

        if (lokerListView != null){
            lokerListView.setAdapter(lokerAdapter);
        }

        lokerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                try{
                    Log.i("LokerView","Item "+i);
                    Log.i("ID",String.valueOf(myLokerList[i].getId()));
                    Log.i("Position",myLokerList[i].getPosition());
                    Log.i("Description",myLokerList[i].getDesc());
                    Log.i("Company",myLokerList[i].getCompany());
                    Log.i("Created_at",myLokerList[i].getCreated_at());
                    Log.i("Updated_at",myLokerList[i].getUpdated_at());
                    Log.i("URL",myLokerList[i].getUrl());
                    Log.i("Submitter",myLokerList[i].getSubmitter());
                } catch (Throwable e){
                    Log.e("Loker Item Click", e.getMessage());
                }
            }
        });
    }
}




