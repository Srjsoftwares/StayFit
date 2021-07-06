package com.example.stayfit;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.TimerTask;

public class SetAlarmActivity extends AppCompatActivity {
    TimePicker alarmTime;
    TextClock currentTime;
    Button Done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);
        Done=findViewById(R.id.Done);
        alarmTime = findViewById(R.id.timePicker);
        currentTime = findViewById(R.id.textClock);
        final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));



        java.util.Timer t = new java.util.Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (currentTime.getText().toString().equals(AlarmTime())){
                    r.play();
                }else{
                    r.stop();
                }
            }
        }, 0, 1000);

        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SetAlarmActivity.this,Dashboard.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }

    public String AlarmTime(){

        Integer alarmHours = alarmTime.getCurrentHour();
        Integer alarmMinutes = alarmTime.getCurrentMinute();
        String stringAlarmMinutes;

        if (alarmMinutes<10){
            stringAlarmMinutes = "0";
            stringAlarmMinutes = stringAlarmMinutes.concat(alarmMinutes.toString());
        }else{
            stringAlarmMinutes = alarmMinutes.toString();
        }
        String stringAlarmTime;

        if(alarmHours>12){
            alarmHours = alarmHours-12;
            stringAlarmTime = alarmHours.toString().concat(":").concat(stringAlarmMinutes).concat("PM");
        }else{
            stringAlarmTime = alarmHours.toString().concat(":").concat(stringAlarmMinutes).concat("AM");
        }
        return stringAlarmTime;
    }
}