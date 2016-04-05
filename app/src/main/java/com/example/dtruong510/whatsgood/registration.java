package com.example.dtruong510.whatsgood;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends AppCompatActivity {

    private Button cancelBtn, registerBtn;
    private EditText passwordET, confirmET, emailET;
    private String email, password, confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        cancelBtn = (Button) findViewById(R.id.buttonCancel);
        cancelBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        registerBtn = (Button) findViewById(R.id.buttonRegister);
        registerBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                passwordET = (EditText) findViewById(R.id.etPassword);
                password = passwordET.getText().toString();

                confirmET = (EditText) findViewById(R.id.etConfirmPass);
                confirm = confirmET.getText().toString();

                if(password.equals(confirm))
                {
                        finish();
                }
                else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Passwords Do Not Match!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });
    }

}
