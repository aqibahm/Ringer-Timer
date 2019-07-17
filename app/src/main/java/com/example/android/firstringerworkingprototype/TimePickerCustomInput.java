package com.example.android.firstringerworkingprototype;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimePickerCustomInput extends AppCompatActivity {

    private TextView mTimeDisplay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_input_timepicker);

        //TimePicker instance
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        TextView mTextView = (TextView) findViewById(R.id.mTextView);

        int hour, minute;



    }



}
