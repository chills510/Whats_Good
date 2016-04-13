package com.example.dtruong510.whatsgood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class profilePage extends AppCompatActivity {
    private Button logOutButton, createServiceButton;
    private EditText usernameET = (EditText) findViewById(R.id.enterEmail);
    private TextView usernameTV = (TextView) findViewById(R.id.usernameTV);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);


        logOutButton = (Button) findViewById(R.id.logoutBtn);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profilePage.this, start_up.class));

            }

        });

        createServiceButton = (Button) findViewById(R.id.createServiceBtn);
        createServiceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profilePage.this, disclaimerPage.class));
            }
        });

    }
}