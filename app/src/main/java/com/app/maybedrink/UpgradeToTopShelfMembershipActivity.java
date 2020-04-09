package com.app.maybedrink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UpgradeToTopShelfMembershipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade_to_top_shelf_membership);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        headerView();
    }
    private void headerView(){
        TextView textView = findViewById(R.id.titleTextView);
        textView.setText("Upgrade to Top Shelf membership");
        LinearLayout backLayout = findViewById(R.id.backLayout);
        backLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void skipClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finishAffinity();
    }

    public void continueClick(View view){
        /*Intent intent = new Intent(this, CompleteProfileStep1Activity.class);
        startActivity(intent);
        finishAffinity();*/
    }

}
