package com.app.maybedrink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ForgotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        headerView();
    }

    private void headerView(){
        TextView textView = findViewById(R.id.titleTextView);
        textView.setText("Forgot password");
        LinearLayout backLayout = findViewById(R.id.backLayout);
        backLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void submitClick(View view){
        Intent intent = new Intent(this, ValidationCodeActivity.class);
        intent.putExtra("openActivity", "newPass");
        startActivity(intent);
    }

}
