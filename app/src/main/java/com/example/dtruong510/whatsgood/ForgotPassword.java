package com.example.dtruong510.whatsgood;

import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    private Button confirmButton, cancelButton;
    EditText emailET;
    String email;

    UserRepo repo = new UserRepo(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        confirmButton = (Button) findViewById(R.id.buttonConfirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailET = (EditText) findViewById(R.id.emailET);
                email = emailET.getText().toString();

                if(repo.checkEmailExists(email))
                {
                    Toast.makeText(ForgotPassword.this, "Password Reset Sent!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgotPassword.this, start_up.class));
                }
                else
                    Toast.makeText(ForgotPassword.this, "Email Not Found", Toast.LENGTH_SHORT).show();

            }


        });

        cancelButton = (Button) findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPassword.this, start_up.class));
            }
        });

    }

}
