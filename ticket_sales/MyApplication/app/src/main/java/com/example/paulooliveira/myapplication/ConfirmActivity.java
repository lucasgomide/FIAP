package com.example.paulooliveira.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {
    private TextView tvName;
    private TextView tvDocument;
    private TextView tvType;
    private TextView tvPeriod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_confirm);
        Bundle params = getIntent().getExtras();

        tvName = (TextView) findViewById(R.id.tvName);
        tvDocument = (TextView) findViewById(R.id.tvDocument);
        tvType = (TextView) findViewById(R.id.tvType);
        tvPeriod = (TextView) findViewById(R.id.tvPeriod);

        tvName.setText(params.getString("name").toString());
        tvDocument.setText(params.getString("document").toString());
        tvType.setText(params.getString("type").toString());
        tvPeriod.setText(params.getString("period").toString());
    }

    public void confirm(View v) {
        Intent confirmed = new Intent(this, ConfirmedActivity.class);
        startActivity(confirmed);
    }
}
