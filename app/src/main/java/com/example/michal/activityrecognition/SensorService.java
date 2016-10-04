package com.example.michal.activityrecognition;


import android.app.IntentService;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;


public class SensorService extends IntentService implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mMagneticSensor;
    private Sensor mLightSensor;

    public SensorService(){
        super("SensorService");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // define all sensor related fields
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mLightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mMagneticSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //here goes sensor code


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // to save battery - unregister listener after the job is done
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}