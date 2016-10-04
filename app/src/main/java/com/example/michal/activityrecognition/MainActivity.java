package com.example.michal.activityrecognition;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mMagneticSensor;
    private Sensor mLightSensor;

    private TextView lightSensorVal;
    private TextView magnetometerVal;

    private final String LOG_TAG = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // define all sensor related fields
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mLightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mMagneticSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        // most used fields
        magnetometerVal = (TextView) findViewById(R.id.tvMagnetometerVal);
        lightSensorVal = (TextView) findViewById(R.id.tvLightSensorVal);


    }

    @Override
    public void onSensorChanged(SensorEvent event){
        if (event.sensor.getType() == Sensor.TYPE_LIGHT){
            float lux = event.values[0];
            lightSensorVal.setText(String.valueOf(lux));
        } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            float val0 = event.values[0];
            float val1 = event.values[1];
            float val2 = event.values[2];

            magnetometerVal.setText(val0 + ", " + val1 + ", " + val2);

        }
        mSensorManager.unregisterListener(this);

    }

    /**
     * Lists all sensors on the device to the android log (debugging purposes)
     */

    private void listInstalledSensors () {
        if (mSensorManager != null) {
            List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
            for (Sensor element : deviceSensors){
                Log.i("SENSORKI", element.getName());

            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //TODO: implement a message if accuracy is very low
    }


    //TODO: this is temp function - delete it in future
    public void updateMeasurements(View v){

    }

    @Override
    protected void onResume() {
        super.onResume();
        //register all sensor again
        mSensorManager.registerListener(this, mLightSensor, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mMagneticSensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //don't waste battery - unregister the sensors
        mSensorManager.unregisterListener(this);
    }
}
