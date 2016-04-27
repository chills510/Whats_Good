package com.example.dtruong510.whatsgood;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class start_up extends AppCompatActivity {
    SessionManager manager;
    private Button lButton, rButton, forgotButton;
    private EditText emailET, passwordET;
    public String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        SQLiteDatabase db = openOrCreateDatabase(UserDBHandler.DATABASE_NAME, MODE_PRIVATE, null);
        manager = new SessionManager();
        final UserRepo repo = new UserRepo(this);

        lButton = (Button) findViewById(R.id.loginButton);
        lButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                emailET = (EditText) findViewById(R.id.enterEmail);
                email = emailET.getText().toString();

                passwordET = (EditText) findViewById(R.id.enterPass);
                password = passwordET.getText().toString();
                if(repo.checkEmailExists(email) && password.equals(repo.checkPassword(email)))
                {
                    manager.setPreferences(start_up.this, "status", "1");
                    String status = manager.getPreferences(start_up.this, "status");
                    Log.d("status", status);

                    Toast.makeText(start_up.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(start_up.this, newsfeed.class);
                    intent.putExtra("getEmail", email);
                    startActivity(intent);
                }
                else
                    Toast.makeText(start_up.this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
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

        forgotButton = (Button) findViewById(R.id.forgotButton);
        forgotButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(start_up.this, ForgotPassword.class));
            }

        });

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);
    }
}
