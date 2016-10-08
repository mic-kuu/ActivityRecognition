package com.example.michal.activityrecognition;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by michal on 08.10.16.
 */

public class SensorReceiver extends BroadcastReceiver {

    public static final int REQUEST_CODE = 12345;
    public static final String ACTION = "com.example.michal.activityrecognition";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, SensorService.class);
        context.startService(i);

    }
}
