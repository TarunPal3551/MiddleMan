package com.example.middleman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class LogInActivity extends AppCompatActivity {
    MaterialButton materialButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        materialButtonLogin = (MaterialButton) findViewById(R.id.loginButton);
        materialButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
