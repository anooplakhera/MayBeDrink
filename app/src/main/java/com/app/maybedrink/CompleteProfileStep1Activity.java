package com.app.maybedrink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CompleteProfileStep1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_profile_step1);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        headerView();
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
        Intent intent = new Intent(this, CompleteProfileStep2Activity.class);
        startActivity(intent);
    }
}
