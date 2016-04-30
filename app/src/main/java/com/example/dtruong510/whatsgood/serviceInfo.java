package com.example.dtruong510.whatsgood;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class serviceInfo extends AppCompatActivity {
    public TextView servicename, description, price, qualitypercent, pricepercent;
    public Button interested, cancel;
    public String stuff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_info);

        //Bundle serviceinfo = getIntent().getExtras();
        //description = (TextView) findViewById(R.id.descriptionTV);
        //description.setText(serviceinfo.getString("servicedata"));

        cancel = (Button) findViewById(R.id.cancelBtn);
        if (cancel != null) {
            cancel.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    finish();
                }
            });
        }


    }

}
