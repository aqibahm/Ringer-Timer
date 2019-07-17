package com.example.android.firstringerworkingprototype;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DialogActivity extends AppCompatActivity {

    //Variables for the app
    int hour = 0, minute = 2, uhour = 0, uminute = 0, hourflag, minuteflag;
    public static int ringerflag = 0;
    String AM_PM = "AM";


    //Classes for the app

    AudioManager am;
    TextView progresstv, targettimetv;
    Button silent, vibrate;
    Intent intent;
    PendingIntent pendingintent;
    Calendar time;
    AlarmManager alarm;

    //Todo: Register receiver in manifest , DONE
    //Todo: Register uses-permission in manifest, DONE
    //Todo: Create new class MyAlarmReceiver, DONE
    //Todo: Set theme of this activity to Theme.AppCompat.Dialog or some other dialog based theme, DONE


    @Override
    protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);

            supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.activity_dialog);


            //Creating instances of the objects defined above\


            //AudioManager instance
            am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

            //TextView instance
            progresstv = (TextView) findViewById(R.id.progressTextView);
            targettimetv = (TextView) findViewById(R.id.targetTimeTextView);

            //SeekBar instance
            SeekBar seekBar = (SeekBar) findViewById(R.id.timeSeekBar);

            //Button instances
            silent = (Button) findViewById(R.id.silentButton);
            vibrate = (Button) findViewById(R.id.vibrateButton);

            //Intent
            intent = new Intent(this, MyAlarmReceiver.class);

            //PendingIntent
            pendingintent = PendingIntent.getBroadcast(this, 0, intent, 0);

            //Calendar instance
            time = Calendar.getInstance();

            //AlarmManager instance
            alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            //Set time of instance as current system time
            time.setTimeInMillis(System.currentTimeMillis());



            targettimetv.setText("Change Till --:--");
            progresstv.setText(getString(R.string.twoMinute));


            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    //Update continuously as the user slides the thumb
                    hour = 0;
                    minute = 2;
                    int progress = seekBar.getProgress();
                    //Running an if-elseif check to assign values for range

                    if (progress > 0 && progress < 7) {
                        progresstv.setText(getString(R.string.twoMinute));
                        minute = 2;
                    } else if (progress > 6 && progress < 10) {
                        progresstv.setText(getString(R.string.fiveMinute));
                        minute = 5;
                    } else if (progress > 9 && progress < 13) {
                        progresstv.setText(getString(R.string.tenMinute));
                        minute = 10;
                    } else if (progress > 12 && progress < 16) {
                        progresstv.setText(getString(R.string.twentyMinute));
                        minute = 20;
                    } else if (progress > 15 && progress < 19) {
                        progresstv.setText(getString(R.string.thirtyMinute));
                        minute = 30;
                    } else if (progress > 18 && progress < 22) {
                        progresstv.setText(getString(R.string.fourtyMinute));
                        minute = 40;
                    } else if (progress > 21 && progress < 25) {
                        progresstv.setText(getString(R.string.fiftyMinute));
                        minute = 50;
                    } else if (progress > 24 && progress < 28) {
                        progresstv.setText(getString(R.string.oneHour));
                        hour = 1;
                    } else if (progress > 27 && progress < 31) {
                        progresstv.setText(getString(R.string.oneHalfHour));
                        hour = 1;
                        minute = 30;
                    } else if (progress > 30 && progress < 34) {
                        progresstv.setText(getString(R.string.twoHour));
                        hour = 2;
                    } else if (progress > 33 && progress < 37) {
                        progresstv.setText(getString(R.string.twoHalfHour));
                        hour = 2;
                        minute = 30;
                    } else if (progress > 36 && progress < 40) {
                        progresstv.setText(getString(R.string.threeHour));
                        hour = 3;
                    } else if (progress > 39 && progress < 43) {
                        progresstv.setText(getString(R.string.threeHalfHour));
                        hour = 3;
                        minute = 30;
                    } else if (progress > 42 && progress < 46) {
                        progresstv.setText(getString(R.string.fourHour));
                        hour = 4;
                    } else if (progress > 45 && progress < 49) {
                        progresstv.setText(getString(R.string.fourHalfHour));
                        hour = 4;
                        minute = 30;
                    } else if (progress > 48 && progress < 52) {
                        progresstv.setText(getString(R.string.fiveHour));
                        hour = 5;
                    } else if (progress > 51 && progress < 55) {
                        progresstv.setText(getString(R.string.fiveHalfHour));
                        hour = 5;
                        minute = 30;
                    } else if (progress > 54 && progress < 58) {
                        progresstv.setText(getString(R.string.sixHour));
                        hour = 6;
                    } else if (progress > 57 && progress < 61) {
                        progresstv.setText(getString(R.string.sixHalfHour));
                        hour = 6;
                        minute = 30;
                    } else if (progress > 60 && progress < 64) {
                        progresstv.setText(getString(R.string.sevenHour));
                        hour = 7;
                    } else if (progress > 63 && progress < 67) {
                        progresstv.setText(getString(R.string.sevenHalfHour));
                        hour = 7;
                        minute = 30;
                    } else if (progress > 66 && progress < 70) {
                        progresstv.setText(getString(R.string.eightHour));
                        hour = 8;
                    } else if (progress > 69 && progress < 73) {
                        progresstv.setText(getString(R.string.eightHalfHour));
                        hour = 8;
                        minute = 30;
                    } else if (progress > 72 && progress < 76) {
                        progresstv.setText(getString(R.string.nineHour));
                        hour = 9;
                    } else if (progress > 75 && progress < 79) {
                        progresstv.setText(getString(R.string.nineHalfHour));
                        hour = 9;
                        minute = 30;
                    } else if (progress > 78 && progress < 82) {
                        progresstv.setText(getString(R.string.tenHour));
                        hour = 10;
                    } else if (progress > 81 && progress < 85) {
                        progresstv.setText(getString(R.string.tenHalfHour));
                        hour = 10;
                        minute = 30;
                    } else if (progress > 84 && progress < 88) {
                        progresstv.setText(getString(R.string.elevenHour));
                        hour = 11;
                    } else if (progress > 87 && progress < 91) {
                        progresstv.setText(getString(R.string.elevenHalfHour));
                        hour = 11;
                        minute = 30;
                    } else if (progress > 90 && progress < 94) {
                        progresstv.setText(getString(R.string.twelveHour));
                        hour = 12;
                    } else if (progress > 93) {
                        progresstv.setText(R.string.changeTillInfinity);
                        hourflag = 1;
                        minuteflag = 1;


                    }
                    time.setTimeInMillis(System.currentTimeMillis());
                    uhour = time.get(Calendar.HOUR_OF_DAY) + hour;
                    uminute = time.get(Calendar.MINUTE) + minute;
                    if(uhour>=12 && uhour<24){
                        AM_PM = "PM";
                        uhour -= 12;
                    }else if(uhour >=24){
                        uhour -= 24;
                        AM_PM = "AM";
                    }
                    if(uminute>=60){
                        uminute -= 60;
                        uhour++;
                    }


                    if (hourflag == 1 && minuteflag == 1){
                        targettimetv.setText(R.string.changeModeIndefinitely);
                        ;
                    }
                    else{
                        targettimetv.setText(getString(R.string.targetTime, uhour, uminute, AM_PM));
                    }

                    hourflag = minuteflag = 0;



                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }


            });


        }

    public void silentOnClick (View view){
        //Sets Ringer Mode to Silent as soon as button is pressed
        ringerflag = 1;
        am.setRingerMode(AudioManager.RINGER_MODE_SILENT);

        if(hourflag == 1 && minuteflag == 1){
            Toast.makeText(this, "Silent Mode Activated Indefinitely", Toast.LENGTH_LONG).show();
        }else{
            //Toast tells user that the ringer mode has been changed
            Toast.makeText(this, "Silent Mode Activated", Toast.LENGTH_LONG).show();}

        time.add(Calendar.HOUR_OF_DAY, hour);
        time.add(Calendar.MINUTE, minute);


        if(hourflag  == 0 && minuteflag ==0){
        //Sets alarm to be triggered as soon as time is reached
        alarm.set(AlarmManager.RTC_WAKEUP, time.getTimeInMillis(), pendingintent);
        }
        this.finish();


    }

    public void vibrateOnClick (View view){
        //Sets Ringer Mode to Vibrate as soon as button is pressed
        ringerflag = 1;
        am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);

        if(hourflag == 1 && minuteflag == 1){
            Toast.makeText(this, "Vibrate Mode Activated Indefinitely", Toast.LENGTH_LONG).show();
        }else{
        //Toast tells user that the ringer mode has been changed
        Toast.makeText(this, "Vibrate Mode Activated", Toast.LENGTH_LONG).show();}

        time.add(Calendar.HOUR_OF_DAY, hour);
        time.add(Calendar.MINUTE, minute);

        if(hourflag == 0 && minuteflag == 0) {
            //Sets alarm to be triggered as soon as time is reached
            alarm.set(AlarmManager.RTC_WAKEUP, time.getTimeInMillis(), pendingintent);
        }
            this.finish();


}

    public void openTimePicker(View view) {
    }
}


