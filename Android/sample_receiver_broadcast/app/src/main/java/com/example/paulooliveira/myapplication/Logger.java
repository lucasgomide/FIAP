package com.example.paulooliveira.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Logger extends Service {
    public Logger() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onCreate(){
        Log.i("ServiceMessage", "Started");
    }

    public void onDestroy() {
        Log.i("ServiceMessage", "Stopped");
    }
}
