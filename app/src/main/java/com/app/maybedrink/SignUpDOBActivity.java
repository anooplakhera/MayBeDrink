package com.app.maybedrink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignUpDOBActivity extends AppCompatActivity {

    String[] day;// = { "Day"};
    String[] month = { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September","October","November","December"};
    String[] year;// = { "Year"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_d_o_b);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        headerView();

        day = new String[32];
        day[0]= "Day";
        for(int i=1; i<=31; i++){
            day[i] = ""+i;
        }

        year = new String[57];
        year[0]= "Year";
        int indexYear = 1;
        for(int i=2005; i>= 1950; i--){
            year[indexYear] = ""+i;
            indexYear++;
        }

        AppCompatSpinner daySpinner = findViewById(R.id.daySpinner);
        ArrayAdapter dayAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item_dob, day);
        dayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_dob);
        daySpinner.setAdapter(dayAdapter);

        AppCompatSpinner monthSpinner = findViewById(R.id.monthSpinner);
        ArrayAdapter monthAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item_dob, month);
        monthAdapter.setDropDownViewResource(R.layout.spinner_dropdown_dob);
        monthSpinner.setAdapter(monthAdapter);

        AppCompatSpinner yearSpinner = findViewById(R.id.yearSpinner);
        ArrayAdapter yearAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item_dob, year);
        yearAdapter.setDropDownViewResource(R.layout.spinner_dropdown_dob);
        yearSpinner.setAdapter(yearAdapter);


    }

    private void headerView(){
        TextView textView = findViewById(R.id.titleTextView);
        textView.setText("DoB");
        LinearLayout backLayout = findViewById(R.id.backLayout);
        backLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void continueClick(View view){
        startActivity(new Intent(SignUpDOBActivity.this, SignUpActivity.class));
    }

}
