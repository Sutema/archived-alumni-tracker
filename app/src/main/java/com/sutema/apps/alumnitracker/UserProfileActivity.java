package com.sutema.apps.alumnitracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserProfileActivity extends AppCompatActivity {
    private EditText fullNameTxt = findViewById(R.id.editText);
    private EditText addressTxt = findViewById(R.id.editText3);
    private EditText emailTxt = findViewById(R.id.editText5);
    private EditText phoneTxt = findViewById(R.id.editText6);

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
