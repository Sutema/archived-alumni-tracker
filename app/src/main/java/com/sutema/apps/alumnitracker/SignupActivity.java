package com.sutema.apps.alumnitracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    EditText confirmpassword;
    TextView serverresponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void SignUp (View view) {
        serverresponse =  findViewById(R.id.textView7);
        name = (EditText) findViewById(R.id.editText8);
        email = (EditText) findViewById(R.id.editText9);
        password = (EditText) findViewById(R.id.editText10);
        confirmpassword = (EditText) findViewById(R.id.editText11);

        System.out.println("email:"+email.getText());
        System.out.println("password"+password.getText());

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://sutema.000webhostapp.com/sutema/signup.php";

        StringRequest postRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response:", response);
                serverresponse.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Response", String.valueOf(error));
                serverresponse.setText((CharSequence) error);
            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("email", String.valueOf(email.getText()));
                params.put("password", String.valueOf(password.getText()));
                return  params;
            }
        };

        queue.add(postRequest);


    }

    }
