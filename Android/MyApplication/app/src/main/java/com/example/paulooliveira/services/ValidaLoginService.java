package com.example.paulooliveira.services;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import java.util.Calendar;
import java.util.Date;

public class ValidaLoginService extends Service {
    public ValidaLoginService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand (Intent intent, int flags, int startid){
        Bundle params = intent.getExtras();
        String email = params.getString("email");
        String password = params.getString("password");
        int day = Integer.parseInt(params.getString("day"));
        int month = Integer.parseInt(params.getString("month"));
        int year = Integer.parseInt(params.getString("year"));
        String menssagem = null;
        if(validateCredentials(email, password) && validateDateOfBirth(day, month, year)) {
            menssagem = "Login efetuado";
        } else {
            menssagem = "Login não efetuado";
        }
        return 0;
    }

    private boolean validateCredentials(String email, String password) {
        return email == "ps@fiap.com.br" && password == "10";
    }

    private boolean validateDateOfBirth(int day, int month, int year) {
        Calendar now = Calendar.getInstance();
        int now_year = now.get(Calendar.YEAR);
        int now_month = now.get(Calendar.MONTH);
        int now_day= now.get(Calendar.DAY_OF_MONTH);

        return  ((now_year - 18) >= year && now_month >= month && now_day >= day);
    }
}
