package com.app.maybedrink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CompleteProfileStep2Activity extends AppCompatActivity {

    String[] occupation = { "Occupation"};
    String[] school = { "School"};
    String[] education = { "Education"};
    String[] religious = { "Religious affiliation"};
    String[] weight = { "Weight"};
    String[] height = { "Height"};
    String[] race = { "Race"};
    String[] status = { "Status"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_profile_step2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        headerView();


        loadSpinner();

    }

    private void loadSpinner() {
        AppCompatSpinner statusSpinner = findViewById(R.id.statusSpinner);
        ArrayAdapter statusAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, status);
        statusAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        statusSpinner.setAdapter(statusAdapter);

        AppCompatSpinner raceSpinner = findViewById(R.id.raceSpinner);
        ArrayAdapter raceAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, race);
        raceAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        raceSpinner.setAdapter(raceAdapter);

        AppCompatSpinner heightSpinner = findViewById(R.id.heightSpinner);
        ArrayAdapter heightAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, height);
        heightAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        heightSpinner.setAdapter(heightAdapter);

        AppCompatSpinner weightSpinner = findViewById(R.id.weightSpinner);
        ArrayAdapter weightAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, weight);
        weightAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        weightSpinner.setAdapter(weightAdapter);

        AppCompatSpinner religiousSpinner = findViewById(R.id.religiousSpinner);
        ArrayAdapter religiousAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, religious);
        religiousAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        religiousSpinner.setAdapter(religiousAdapter);

        AppCompatSpinner educationSpinner = findViewById(R.id.educationSpinner);
        ArrayAdapter educationAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, education);
        educationAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        educationSpinner.setAdapter(educationAdapter);

        AppCompatSpinner schoolSpinner = findViewById(R.id.schoolSpinner);
        ArrayAdapter schoolAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, school);
        schoolAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        schoolSpinner.setAdapter(schoolAdapter);

        AppCompatSpinner occupationSpinner = findViewById(R.id.occupationSpinner);
        ArrayAdapter occupationAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, occupation);
        occupationAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        occupationSpinner.setAdapter(occupationAdapter);
    }


    private void headerView(){
        TextView textView = findViewById(R.id.titleTextView);
        textView.setText("Complete your profile");
        LinearLayout backLayout = findViewById(R.id.backLayout);
        backLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void nextClick(View view){
        Intent intent = new Intent(this, CompleteProfileStep3Activity.class);
        startActivity(intent);
    }
}
