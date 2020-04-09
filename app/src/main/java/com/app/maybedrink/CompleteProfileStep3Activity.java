package com.app.maybedrink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CompleteProfileStep3Activity extends AppCompatActivity {

    String[] political = { "Political affiliation"};
    String[] kid = { "Have kids"};
    String[] kidWant = { "Want kids?"};
    String[] drink = { "Do you drink?"};
    String[] smoke = { "Do you smoke?"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_profile_step3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        headerView();

        loadSpinner();
    }

    private void loadSpinner() {
        AppCompatSpinner politicalSpinner = findViewById(R.id.politicalSpinner);
        ArrayAdapter politicalAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, political);
        politicalAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        politicalSpinner.setAdapter(politicalAdapter);

        AppCompatSpinner kidSpinner = findViewById(R.id.kidSpinner);
        ArrayAdapter kidAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, kid);
        kidAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        kidSpinner.setAdapter(kidAdapter);

        AppCompatSpinner kidWantSpinner = findViewById(R.id.kidWantSpinner);
        ArrayAdapter kidWantAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, kidWant);
        kidWantAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        kidWantSpinner.setAdapter(kidWantAdapter);

        AppCompatSpinner drinkSpinner = findViewById(R.id.drinkSpinner);
        ArrayAdapter drinkAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, drink);
        drinkAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        drinkSpinner.setAdapter(drinkAdapter);

        AppCompatSpinner smokeSpinner = findViewById(R.id.smokeSpinner);
        ArrayAdapter smokeAdapter = new ArrayAdapter(this,R.layout.spinner_dropdown_item, smoke);
        smokeAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        smokeSpinner.setAdapter(smokeAdapter);
    }

    private void headerView() {
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

    public void saveClick(View view) {
        Intent intent = new Intent(this, UpgradeToTopShelfMembershipActivity.class);
        startActivity(intent);
    }

}