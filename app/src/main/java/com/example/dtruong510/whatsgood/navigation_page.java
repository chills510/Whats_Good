package com.example.dtruong510.whatsgood;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class navigation_page extends AppCompatActivity {

    private Button navCreateService, navProfile, navHomepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navCreateService = (Button) findViewById(R.id.buttonCreateService);
        navCreateService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(navigation_page.this, disclaimerPage.class));
            }
        });

        navProfile = (Button) findViewById(R.id.buttonProfile);
        navProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(navigation_page.this, profilePage.class));
            }
        });

        navHomepage = (Button) findViewById(R.id.buttonHomepage);
        navHomepage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(navigation_page.this, homepage.class));
            }
        });


    }

}
