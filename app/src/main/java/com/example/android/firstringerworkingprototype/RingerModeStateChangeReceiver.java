package com.example.android.firstringerworkingprototype;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;



public class RingerModeStateChangeReceiver extends BroadcastReceiver {

    AudioManager audiomanager;
    @Override
    public void onReceive(Context context, Intent intent) {
        audiomanager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        Intent intent1 = new Intent(context, DialogActivity.class);
        if((audiomanager.getRingerMode() == AudioManager.RINGER_MODE_VIBRATE || audiomanager.getRingerMode() == AudioManager.RINGER_MODE_SILENT) && DialogActivity.ringerflag == 1){
            //Checks if ringerflag has been changed, which will only happen when the buttons are pressed, if so, changes them back to the original state to reuse again in near future

            DialogActivity.ringerflag = 0;

        }
        else if(audiomanager.getRingerMode() != AudioManager.RINGER_MODE_NORMAL && DialogActivity.ringerflag == 0){
            context.startActivity(intent1);
        }

    }
}
