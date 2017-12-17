package com.sutema.apps.alumnitracker;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

        //FetchLoker fetchLoker = new FetchLoker();
        //fetchLoker.execute();

        FloatingActionButton createLokerBtn = findViewById(R.id.floatingActionButton);
        createLokerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLokerForm();
            }
        });

        // Exp Basic Listview
        emptyIcon.setVisibility(View.INVISIBLE);
        notifTxt.setVisibility(View.INVISIBLE);
        lokerListView.setVisibility(View.VISIBLE);
        final String[] myStringArray = new String[]{
                "Javascript",
                "MySQL",
                "Java",
                "HTML5",
                "CSS"
        };

        final Loker[] myLokerData = new Loker[]{
                new Loker(1,"Javascript","Javascript Corp"),
                new Loker(2,"MySQL","MySQL Corp"),
                new Loker(3,"Java", "Java Corp"),
                new Loker(4,"HTML5","HTML5 Corp"),
                new Loker(5,"CSS","CSS Corp")
        };

        lokerAdapter = new LokerAdapter(this,R.layout.loker_row, myLokerData);

        if(lokerListView != null){
            lokerListView.setAdapter(lokerAdapter);
        }

        lokerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Loker", myStringArray[i]);
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
        ArrayList<Loker> lokerArrayList = new ArrayList<>();

        for (int i = 0; i < myLokerList.length; i++){
            Loker lokerObj = new Loker();
            lokerObj.setId(myLokerList[i].getId());
            lokerObj.setCompany(myLokerList[i].getCompany());
            lokerArrayList.add(lokerObj);
        }

        ArrayAdapter<Loker> lokerArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, lokerArrayList);

        lokerListView.setAdapter(lokerArrayAdapter);
        lokerListView.setOnItemClickListener(lokerClickHandler);
    }

    private AdapterView.OnItemClickListener lokerClickHandler = new AdapterView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView adapterView, View view, int i, long l) {
            Object objClick = lokerListView.getItemAtPosition(i);

            Log.i("LokerView","Item "+i);
            Log.i("Obj",objClick.toString());
        }
    };
}




