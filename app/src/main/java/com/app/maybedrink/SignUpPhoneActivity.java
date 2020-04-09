package com.app.maybedrink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignUpPhoneActivity extends AppCompatActivity {

    String[] lookingFor = { "Gender", "Female", "Male", "Transgender Female", "Transgender Male"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_phone);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        headerView();


        AppCompatSpinner lookingForSpinner = findViewById(R.id.lookingForSpinner);
        ArrayAdapter lookingForAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, lookingFor);
        lookingForAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        lookingForSpinner.setAdapter(lookingForAdapter);
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

    public void submitClick(View view){
        startActivity(new Intent(SignUpPhoneActivity.this, ValidationCodeActivity.class));
    }

}
