package com.example.fcm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void onStart() {
        String my_tag="start";
        super.onStart();
        Log.i(my_tag,"onStart");
        Toast.makeText(getApplicationContext(),"app started",Toast.LENGTH_LONG).show();

    }
    protected void onDestroy() {
        String my_tag="destroy";
        super.onDestroy();
        Log.i(my_tag,"onDestroy");
        Toast.makeText(getApplicationContext(),"app closed",Toast.LENGTH_LONG).show();
    }
    protected void onResume() {
        String my_tag="resume";
        super.onResume();
        Log.i(my_tag,"onDestroy");
        Toast.makeText(getApplicationContext(),"app resumed",Toast.LENGTH_LONG).show();
    }


}
