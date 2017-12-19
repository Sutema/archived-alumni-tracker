package com.sutema.apps.alumnitracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserProfileActivity extends AppCompatActivity {
    EditText fullNameTxt;
    EditText addressTxt;
    EditText emailTxt;
    EditText phoneTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        fullNameTxt =  findViewById(R.id.editText);
        addressTxt =  findViewById(R.id.editText3);
        emailTxt =  findViewById(R.id.editText5);
        phoneTxt =  findViewById(R.id.editText6);

        User user = getUserProfile();

        //Set user profile in Form
        renderFormData(user);
    }

    User getUserProfile(){
        User user = new User();
        user.setId(9999);
        user.setFullName("Dummy People");
        user.setAddress("Sesame Street");
        user.setEmail("dummy@people.com");
        user.setPhone("089999991234");

        return user;
    }

    void renderFormData(User user){
        fullNameTxt.setText(user.getFullName());
        addressTxt.setText(user.getAddress());
        emailTxt.setText(user.getEmail());
        phoneTxt.setText(user.getPhone());

    }

    public void updateUser(View view){
        User user = new User();
        user.setFullName(fullNameTxt.getText().toString());
        user.setAddress(addressTxt.getText().toString());
        user.setEmail(emailTxt.getText().toString());
        user.setPhone(phoneTxt.getText().toString());

    }
}
