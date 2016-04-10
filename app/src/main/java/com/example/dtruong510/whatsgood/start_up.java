package com.example.dtruong510.whatsgood;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class start_up extends AppCompatActivity {

    private Button lButton, rButton;
    private EditText emailET, passwordET;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        final UserRepo repo = new UserRepo(this);
        final User user = new User();

        lButton = (Button) findViewById(R.id.loginButton);
        lButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailET = (EditText) findViewById(R.id.enterEmail);
                email = emailET.getText().toString();

                passwordET = (EditText) findViewById(R.id.enterPass);
                password = passwordET.getText().toString();

                repo.checkIfExists(email);

                if (password.equals(repo.checkIfExists(password))) {
                    Toast.makeText(start_up.this, "Successfully Logged In!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(start_up.this, homepage.class));
                }
                else
                    Toast.makeText(start_up.this, "Email Not Found", Toast.LENGTH_SHORT).show();
            }
        });

        rButton = (Button) findViewById(R.id.registerButton);
        rButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(start_up.this, registration.class));
            }
        });

    }

}
