package com.example.michal.activityrecognition;



import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


public class SensorService extends Service implements SensorEventListener {

    private SensorManager sensorMangaer;
    private Sensor lSensor;


    public static final String TAG = "BUDZIK";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "OnCreate");
        sensorMangaer = (SensorManager) getApplicationContext().getSystemService(SENSOR_SERVICE);
        lSensor = sensorMangaer.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorMangaer.registerListener(this, lSensor, SensorManager.SENSOR_DELAY_NORMAL);
        Log.i(TAG, "Zarejestrowano listener w onCreate");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "OnStart again");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        Log.i(TAG, String.valueOf(sensorEvent.values[0]));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}