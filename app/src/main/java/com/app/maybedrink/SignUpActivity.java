package com.app.maybedrink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    String[] gender = { "Gender", "Female", "Male", "Transgender Female", "Transgender Male"};
    String[] seeking = { "I'm here for", "Anything","Marriage","Long-Term Relationship", "Something Serious","Casual Dating","Friends With Benefits","Fun","Just Browsing"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        headerView();


        AppCompatSpinner genderSpinner = findViewById(R.id.genderSpinner);
        ArrayAdapter genderAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item,gender);
        genderAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        genderSpinner.setAdapter(genderAdapter);

        AppCompatSpinner seekingSpinner = findViewById(R.id.seekingSpinner);
        ArrayAdapter seekingAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, seeking);
        seekingAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        seekingSpinner.setAdapter(seekingAdapter);

    }

    private void headerView(){
        TextView textView = findViewById(R.id.titleTextView);
        textView.setText("Sign up");
        LinearLayout backLayout = findViewById(R.id.backLayout);
        backLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void signUpClick(View view){
        startActivity(new Intent(SignUpActivity.this, SignUpPhoneActivity.class));
    }

}
