package com.sutema.apps.alumnitracker;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static android.app.PendingIntent.getActivity;

public class LokerFormActivity extends AppCompatActivity {
    TextInputLayout position;
    TextInputLayout description;
    TextInputLayout company;
    TextInputLayout deadline;
    TextInputLayout url;
    AppDatabase appDatabase;
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
        newLoker = new Loker();
        newLoker = collectForm();
        new SaveNewLoker().execute(newLoker);
    }

    public Loker collectForm(){
        Loker dataForm = new Loker();
        try{
            dataForm.id = generateId();
            dataForm.position = position.getEditText().getText().toString();
            dataForm.desc = description.getEditText().getText().toString();
            dataForm.company = company.getEditText().getText().toString();
            dataForm.deadline_at = reformattedDate(new Date(deadline.getEditText().getText().toString())) ;
            dataForm.url = url.getEditText().getText().toString();
            dataForm.created_at = reformattedDate(new Date());
            dataForm.updated_at = null;
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(date);
    }

    public class SaveNewLoker extends AsyncTask<Loker, Integer, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "sutema.db").build();
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

        @Override
        protected String doInBackground(Loker... lokers) {
            appDatabase.lokerDAO().insert(lokers);
            return null;
        }
    }
}
