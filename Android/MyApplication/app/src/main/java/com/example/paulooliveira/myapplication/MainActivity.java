package com.example.paulooliveira.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paulooliveira.services.ValidaLoginService;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText email = null;
    private EditText password = null;
    private DatePicker dateOfBirth = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void validarLogin(View v) {
        email = (EditText) findViewById(R.id.txtEmail);
        password = (EditText) findViewById(R.id.txtPassword);
        dateOfBirth = (DatePicker) findViewById(R.id.dpdateOfBirth);
        Intent i = new Intent(this, ValidaLoginService.class);

        i.putExtra("email", email.getText().toString());
        i.putExtra("password", password.getText().toString());
        i.putExtra("day", dateOfBirth.getDayOfMonth());
        i.putExtra("month", dateOfBirth.getMonth());
        i.putExtra("year", dateOfBirth.getYear());

        startService(i);
    }

}
