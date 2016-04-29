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

public class disclaimerPage extends AppCompatActivity {

    private Button agreeBtn, disagreeBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        agreeBtn = (Button) findViewById(R.id.agreeButton);
        agreeBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(disclaimerPage.this, "Thank You For Understanding!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(disclaimerPage.this, createService.class));
            }
        });

        disagreeBtn = (Button) findViewById(R.id.disagreeButton);
        disagreeBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(disclaimerPage.this, "We're Sorry You Disagree!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(disclaimerPage.this, newsfeed.class));
            }
        });
    }

}
