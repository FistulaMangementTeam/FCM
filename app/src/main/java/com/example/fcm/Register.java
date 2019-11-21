package com.example.fcm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    DataBaseHelper db;
    EditText username;
    EditText password;
    EditText confirm;
    TextView backlogin;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DataBaseHelper(this);

        username = findViewById(R.id.ruser);
        password = findViewById(R.id.rpass);
        confirm = findViewById(R.id.rcpass);
        register = findViewById(R.id.rbut);
        backlogin = findViewById(R.id.rlogin);
        backlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Register.this, MainActivity.class);
                startActivity(myintent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setText("");
                password.setText("");
                confirm.setText("");
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String cof_pass = confirm.getText().toString().trim();
                if (pass.equals(cof_pass)) {
                    long val = db.Add_user(user, pass);
                    if (val > 0) {
                        Toast.makeText(Register.this, "you have registered", Toast.LENGTH_SHORT).show();
                        Intent movetologin = new Intent(Register.this, MainActivity.class);
                        startActivity(movetologin);

                    } else {
                        Toast.makeText(Register.this, "failed to register", Toast.LENGTH_SHORT).show();
                    }


                } else {

                    Toast.makeText(Register.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
