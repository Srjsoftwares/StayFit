package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatch extends AppCompatActivity {

    Button ButtonStart, ButtonStop;
    ImageView clock_anchor;
    Animation rotation;
    Chronometer StopwatchTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);


        ButtonStart = findViewById(R.id.ButtonStart);
        ButtonStop = findViewById(R.id.ButtonStop);
        clock_anchor = findViewById(R.id.clock_anchor);
        StopwatchTimer= findViewById(R.id.StopwatchTimer);

        //Optional Animation
        ButtonStop.setAlpha(0);


        //load Animation
        rotation = AnimationUtils.loadAnimation(this, R.anim.rotation);


        //Onclick Button
        ButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing animation
                clock_anchor.startAnimation(rotation);
                ButtonStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                ButtonStart.animate().alpha(0).setDuration(300).start();
                //start time
                StopwatchTimer.setBase(SystemClock.elapsedRealtime());
                StopwatchTimer.start();

            }
        });

        ButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clock_anchor.clearAnimation();

                ButtonStart.animate().alpha(1).translationY(-80).setDuration(300).start();
                ButtonStop.animate().alpha(0).setDuration(300).start();
                StopwatchTimer.stop();
            }
        });

    }
}