package com.example.paulooliveira.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logon(View v) {
        Intent i = new Intent();
        i.setAction("android.intent.action.ACTION_PASSWORD_SUCCESSED");

        sendBroadcast(i);
    }
}
