package com.example.dtruong510.whatsgood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class start_up extends AppCompatActivity {

    private Button lButton, rButton, fpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        fpButton = (Button) findViewById(R.id.buttonFP);
        fpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(start_up.this, ForgotPassword.class));
            }
        });

        lButton = (Button) findViewById(R.id.loginButton);
        lButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(start_up.this, homepage.class));
            }
        });

        rButton = (Button) findViewById(R.id.registerButton);
        rButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(start_up.this, registration.class));
            }
        });

        }

}
