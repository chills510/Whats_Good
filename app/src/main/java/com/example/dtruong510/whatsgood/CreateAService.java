package com.example.dtruong510.whatsgood;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

public class CreateAService extends AppCompatActivity {

    private Button cButton, caButton;
    private EditText serviceET, descriptionET, priceET;
    private int priceVal;
    private String serviceNameText, descriptionText;
    private int _ServiceID = 0;

    public CreateAService(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_a_service);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ServiceRepo repo = new ServiceRepo(this);
        final Service service = new Service();

        cButton = (Button) findViewById(R.id.buttonCreate);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceET = (EditText) findViewById(R.id.serviceEt);
                serviceNameText = serviceET.getText().toString();

                descriptionET = (EditText) findViewById(R.id.descriptionEt);
                descriptionText = descriptionET.getText().toString();

                priceET = (EditText) findViewById(R.id.priceEt);
                priceVal = Integer.parseInt(priceET.getText().toString());

                service.service_name = serviceNameText;
                service.service_description = descriptionText;
                service.service_price = priceVal;

                _ServiceID = repo.insert(service);

                startActivity(new Intent(CreateAService.this, homepage.class));
            }
        });

        caButton = (Button) findViewById(R.id.buttonCancel);
        caButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateAService.this, homepage.class));
            }
        });

    }

}
