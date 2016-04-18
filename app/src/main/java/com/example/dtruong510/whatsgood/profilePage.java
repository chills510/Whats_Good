package com.example.dtruong510.whatsgood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class profilePage extends AppCompatActivity {
    private Button logOutButton, createServiceButton, editButton, myServicesButton;
    String newUsername;
    public EditText usernameET = (EditText) findViewById(R.id.enterEmail);
    public TextView usernameTV = (TextView) findViewById(R.id.usernameTV);
    Intent iEmail = getIntent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        //newUsername = getIntent().getExtras().getString("passEmail");
        //usernameTV.setText(newUsername);

        logOutButton = (Button) findViewById(R.id.logoutBtn);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(profilePage.this, "Logged Out", Toast.LENGTH_SHORT).show();
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

        myServicesButton = (Button) findViewById(R.id.btMyServices);
        myServicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profilePage.this, my_services.class));
            }
        });


    }
}