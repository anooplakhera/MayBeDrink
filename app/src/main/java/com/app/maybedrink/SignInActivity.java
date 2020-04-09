package com.app.maybedrink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        TextView textView = findViewById(R.id.titleTextView);
        textView.setText("Sign in");

    }


    public void signInClick(View view){
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void signUpClick(View view){
        startActivity(new Intent(SignInActivity.this, SignUpDOBActivity.class));
    }
    public void forgotClick(View view){
        startActivity(new Intent(SignInActivity.this, ForgotActivity.class));
    }


}
