    package com.example.stayfit;
    
    import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
    
    public class StopWatchActivity extends AppCompatActivity {
        TextView tvSplash , tvSubSplash;
        Button stopwatchButton, stopwatchBack;
        ImageView ivSplash;
        Animation text0,text1,text2;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
    
            tvSplash= findViewById(R.id.tvSplash);
            tvSubSplash= findViewById(R.id.tvSubSplash);
            stopwatchButton = findViewById(R.id.stopwatchButton);
            stopwatchBack= findViewById(R.id.stopwatchBack);
            ivSplash= findViewById(R.id.ivSplash);
    
            //load Animations
            text0= AnimationUtils.loadAnimation(this,R.anim.text0);
            text1= AnimationUtils.loadAnimation(this,R.anim.text1);
            text2= AnimationUtils.loadAnimation(this,R.anim.text2);
    
            //passing animation
            ivSplash.startAnimation(text0);
            tvSplash.startAnimation(text1);
            tvSubSplash.startAnimation(text1);
            stopwatchButton.startAnimation(text2);
            stopwatchBack.startAnimation(text2);
    
            //passing event
            stopwatchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a = new Intent(StopWatchActivity.this, StopWatch.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(a);
                }
            });
            stopwatchBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a = new Intent(StopWatchActivity.this,Dashboard.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(a);
                }
            });

        }
    }