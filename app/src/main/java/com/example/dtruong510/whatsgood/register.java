package com.example.dtruong510.whatsgood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class register extends AppCompatActivity implements View.OnClickListener{

    EditText editEmail, editPassword, editRePassword;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editRePassword = (EditText) findViewById(R.id.editTextRePassword);

        buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.buttonRegister:

                break;
        }
    }

}
