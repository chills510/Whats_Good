package com.example.dtruong510.whatsgood;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//activity page
public class registration extends AppCompatActivity {

    private Button cancelBtn, registerBtn;
    private EditText passwordET, confirmET, emailET;
    private String email, password, confirm;
    private int _UserID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final UserRepo repo = new UserRepo(this);
        final User user = new User();

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

                emailET = (EditText) findViewById(R.id.etEmail);
                email = emailET.getText().toString();

                user.user_ID = _UserID;
                user.email = email;
                user.password = password;

                if(password.equals(confirm))
                {
                    if(_UserID == 0)
                    {
                        _UserID = repo.insert(user);

                        Context context = getApplicationContext();
                        CharSequence text = "New User Insert";
                        int duration = Toast.LENGTH_SHORT;
                        Toast.makeText(context, text, duration).show();
                    }
                    else
                    {
                        repo.update(user);
                        Context context = getApplicationContext();
                        CharSequence text = "User Record Updated";
                        int duration = Toast.LENGTH_SHORT;
                        Toast.makeText(context, text, duration).show();
                    }
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

        cancelBtn = (Button) findViewById(R.id.buttonCancel);
        cancelBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }

}
