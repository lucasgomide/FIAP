package com.example.paulooliveira.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name = null;
    private EditText document = null;
    private Spinner type = null;
    private RadioGroup groupPeriod = null;
    private RadioButton period = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View v) {
        name = (EditText) findViewById(R.id.edName);
        document = (EditText) findViewById(R.id.edDocument);
        type = (Spinner) findViewById(R.id.spType);
        groupPeriod = (RadioGroup) findViewById(R.id.rgPeriod);
        period = (RadioButton) findViewById(groupPeriod.getCheckedRadioButtonId());

        Intent confirm = new Intent(this, ConfirmActivity.class);

        confirm.putExtra("name", name.getText().toString());
        confirm.putExtra("document", document.getText().toString());
        confirm.putExtra("type", type.getSelectedItem().toString());
        confirm.putExtra("period", period.getText());

        startActivity(confirm);
    }
}
