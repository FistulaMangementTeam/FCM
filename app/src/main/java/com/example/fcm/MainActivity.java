package com.example.fcm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
//defining our variables to use
    EditText username;
    EditText password;
    TextView textView;
    Button log;

    //database helper class defined
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_people_outline_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);

        db = new DataBaseHelper(this);

        //calling the onclick methods

        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        log = (Button) findViewById(R.id.login);
        textView = (TextView) findViewById(R.id.register);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, Register.class);
                startActivity(myintent);

            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=username.getText().toString();
                String s2=password.getText().toString();
             if(s.equals("")||s2.equals("")){
                 Toast.makeText(getApplicationContext(),"credentials requried",Toast.LENGTH_LONG).show();
             }
                else {

                  Intent myintent = new Intent(MainActivity.this, Visit.class);
                  startActivity(myintent);
              }

            }
        });



    }

//ACTIVITY STATE METHODS
    protected void onStart() {
        String my_tag = "start";
        super.onStart();
        Log.i(my_tag, "onStart");
        Toast.makeText(getApplicationContext(), "app started", Toast.LENGTH_LONG).show();

    }

    protected void onDestroy() {
        String my_tag = "destroy";
        super.onDestroy();
        Log.i(my_tag, "onDestroy");
        Toast.makeText(getApplicationContext(), "app closed", Toast.LENGTH_LONG).show();
    }

    protected void onResume() {
        String my_tag = "resume";
        super.onResume();
        Log.i(my_tag, "onDestroy");
        Toast.makeText(getApplicationContext(), "app resumed", Toast.LENGTH_LONG).show();
    }




}
