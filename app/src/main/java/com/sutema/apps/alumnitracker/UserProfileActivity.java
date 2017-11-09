package com.sutema.apps.alumnitracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        User user = getUserProfile();

        //Set user profile in Form
        renderFormData(user);
    }

    User getUserProfile(){
        User user = new User();
        user.setID(9999);
        user.setFullName("Dummy People");
        user.setAddress("Jalan kehidupan");
        user.setEmail("dummy@people.com");
        user.setPhone("089999991234");

        return user;
    }

    void renderFormData(User user){
        EditText fullNameTxt = findViewById(R.id.editText);
        EditText addressTxt = findViewById(R.id.editText3);
        EditText emailTxt = findViewById(R.id.editText5);
        EditText phoneTxt = findViewById(R.id.editText6);

        fullNameTxt.setText(user.getFullName());
        addressTxt.setText(user.getAddress());
        emailTxt.setText(user.getEmail());
        phoneTxt.setText(user.getPhone());

    }
}
