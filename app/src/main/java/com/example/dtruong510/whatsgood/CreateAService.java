package com.example.dtruong510.whatsgood;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;

public class CreateAService extends AppCompatActivity {
    private Button cancelB, addPhotos, createButton;
    private EditText serviceNameET, priceET, hoursET, descriptionET;
    private String serviceName, price, hours, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_a_service);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SQLiteDatabase db = openOrCreateDatabase(ServiceDBHandler.DATABASE_NAME, MODE_PRIVATE, null);
        final ServiceRepo repo = new ServiceRepo(this);

        createButton = (Button) findViewById(R.id.buttonCreate);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceNameET = (EditText) findViewById(R.id.serviceET);
                serviceName = serviceNameET.getText().toString();

                priceET = (EditText) findViewById(R.id.priceET);
                price = priceET.getText().toString();

                hoursET = (EditText) findViewById(R.id.hoursET);
                hours = hoursET.getText().toString();

                descriptionET = (EditText) findViewById(R.id.descriptionET);
                description = descriptionET.getText().toString();

                if(repo.checkServiceExists(serviceName)){
                    Toast.makeText(CreateAService.this, "Service name already exists", Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(CreateAService.this, "Successfully added a service", Toast.LENGTH_SHORT).show();;


            }
        });

        cancelB = (Button) findViewById(R.id.buttonCancel);
        cancelB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateAService.this, homepage.class));
            }
        });
    }

}
