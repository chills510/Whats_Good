package com.example.dtruong510.whatsgood;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Blob;

public class profilePage extends AppCompatActivity {
    SessionManager manager;
    private TextView username;
    private Button editBtn, myServicesBtn, logoutBtn;
    private Blob profilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        manager = new SessionManager();

        Bundle extras = getIntent().getExtras();
        username = (TextView) findViewById(R.id.emailTV);
        username.setText(extras.getString("getEmail"));


        editBtn = (Button) findViewById(R.id.editAccount);
        editBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(profilePage.this, editAccount.class));
            }
        });

        myServicesBtn = (Button) findViewById(R.id.myServices);



        logoutBtn = (Button) findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                manager.setPreferences(profilePage.this, "status", "0");
                startActivity(new Intent(profilePage.this, start_up.class));
            }
        });
    }
}
