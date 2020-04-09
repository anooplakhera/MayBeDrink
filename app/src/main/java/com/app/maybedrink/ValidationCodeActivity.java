package com.app.maybedrink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ValidationCodeActivity extends AppCompatActivity {

    private String openActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_code);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        if(getIntent().hasExtra("openActivity"))
        {
            openActivity = getIntent().getExtras().getString("openActivity");
            getIntent().removeExtra("openActivity");
        }

        headerView();
    }

    private void headerView(){
        TextView textView = findViewById(R.id.titleTextView);
        textView.setText("Validation code");
        LinearLayout backLayout = findViewById(R.id.backLayout);
        backLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void submitClick(View view){
        if(openActivity!=null && openActivity.trim().equalsIgnoreCase("newPass")) {
            Intent intent = new Intent(this, NewPasswordActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Intent intent = new Intent(this, SignUpCompleteMsgActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
