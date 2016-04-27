package com.example.dtruong510.whatsgood;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class createService extends AppCompatActivity {

    private Button cButton, caButton;
    private CheckBox salesCheck;
    private EditText serviceET, descriptionET, priceET;
    private float priceVal;
    private String serviceNameText, descriptionText;
    private int _ServiceID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_service);

        final ServiceRepo repo = new ServiceRepo(this);
        final Service service = new Service();

        cButton = (Button) findViewById(R.id.createBtn);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceET = (EditText) findViewById(R.id.nameET);
                serviceNameText = serviceET.getText().toString();

                descriptionET = (EditText) findViewById(R.id.descriptionET);
                descriptionText = descriptionET.getText().toString();

                priceET = (EditText) findViewById(R.id.priceET);
                priceVal = Float.parseFloat(priceET.getText().toString());

                salesCheck = (CheckBox) findViewById(R.id.salesBox);
                if(salesCheck.isChecked())
                {
                    service.sales_check = true;
                }

                service.service_name = serviceNameText;
                service.service_description = descriptionText;
                service.service_price = priceVal;

                _ServiceID = repo.insert(service);

                finish();
            }
        });

        caButton = (Button) findViewById(R.id.cancelBtn);
        caButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
