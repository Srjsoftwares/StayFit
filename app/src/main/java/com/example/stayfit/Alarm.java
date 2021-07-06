package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Alarm extends AppCompatActivity {
    TextView tvSplash , tvSubSplash;
    Button alarmButton, alarmBack;
    ImageView ivSplash;
    Animation text0,text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        tvSplash= findViewById(R.id.tvSplash);
        tvSubSplash= findViewById(R.id.tvSubSplash);
        alarmButton = findViewById(R.id.alarmButton);
        alarmBack= findViewById(R.id.alarmBack);
        ivSplash= findViewById(R.id.ivSplash);

        //load Animations
        text0= AnimationUtils.loadAnimation(this,R.anim.text0);
        text1= AnimationUtils.loadAnimation(this,R.anim.text1);
        text2= AnimationUtils.loadAnimation(this,R.anim.text2);

        //passing animation
        try {
            ivSplash.startAnimation(text0);
            tvSplash.startAnimation(text1);
            tvSubSplash.startAnimation(text1);
            alarmButton.startAnimation(text2);
            alarmBack.startAnimation(text2);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        alarmBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Alarm.this,Dashboard.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Alarm.this,SetAlarmActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }
}