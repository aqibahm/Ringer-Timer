package com.example.android.firstringerworkingprototype;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.Toast;

public class MyAlarmReceiver extends BroadcastReceiver{

    //Todo: Initialize a new AudioManager instance, DONE
    //Todo: Change Ringer Mode to Normal, DONE
    //Todo: Create new Toast to show that Ringer Mode has been changed to normal, DONE

    AudioManager audio;


    @Override
    public void onReceive(Context context, Intent intent) {
        audio = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        Toast.makeText(context, "Ringer Mode Changed To Normal", Toast.LENGTH_SHORT).show();

    }
}
