package com.sutema.apps.alumnitracker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class LokerFormActivity extends AppCompatActivity {
    TextInputLayout position;
    TextInputLayout description;
    TextInputLayout company;
    TextInputLayout deadline;
    TextInputLayout url;


    Loker newLoker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loker_form);

        position = findViewById(R.id.TIL_position);
        description = findViewById(R.id.TIL_desc);
        company = findViewById(R.id.TIL_company);
        deadline = findViewById(R.id.TIL_deadline);
        url = findViewById(R.id.TIL_url);
    }

    public void saveForm(View view){
        try{
            newLoker = new Loker();
            newLoker = collectForm();
            new SaveNewLoker().execute();
        }catch (Exception e){
            Log.e("saveForm()",e.getMessage());
        }
    }

    public Loker collectForm(){
        Loker dataForm = new Loker();
        try{
            dataForm.setId(generateId());
            dataForm.setPosition(position.getEditText().getText().toString());
            dataForm.setDesc(description.getEditText().getText().toString());
            dataForm.setCompany(company.getEditText().getText().toString());
            dataForm.setDeadlineAt(reformattedDate(new Date(deadline.getEditText().getText().toString()))); ;
            dataForm.setUrl(url.getEditText().getText().toString());
            dataForm.setCreatedAt(reformattedDate(new Date()));
            dataForm.setUpdatedAt(null);
        }catch (Exception e){
            Log.e("collectForm",e.getMessage());
        }

        return dataForm;
    }

    public int generateId(){
        Random random = new Random();
        return random.nextInt(2147483647) + 1;
    }

    public String reformattedDate(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US);
        return dateFormat.format(date);
    }

    @SuppressLint("StaticFieldLeak")
    public class SaveNewLoker extends AsyncTask<Void, Integer, String>{

        @Override
        protected String doInBackground(Void... voids) {
            try{

            }catch (Exception e){
                Log.e("LokerFormAct",e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(LokerFormActivity.this, "Loker published...", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), MyLokerActivity.class);
            startActivity(intent);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
}
