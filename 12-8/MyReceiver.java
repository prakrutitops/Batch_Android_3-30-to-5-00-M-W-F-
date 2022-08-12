package com.example.animationex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {

        if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED))
        {
            Toast.makeText(context, "Battery Action Changed", Toast.LENGTH_SHORT).show();
        }

    }
}