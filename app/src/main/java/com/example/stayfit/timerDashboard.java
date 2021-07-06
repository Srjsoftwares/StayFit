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

public class timerDashboard extends AppCompatActivity {
    TextView tvSplash , tvSubSplash;
    Button timerButton,timerBack;
    ImageView ivSplash;
    Animation text0,text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_dashboard);

        tvSplash= findViewById(R.id.tvSplash);
        tvSubSplash= findViewById(R.id.tvSubSplash);
        timerButton = findViewById(R.id.timerButton);
        timerBack= findViewById(R.id.timerBack);
        ivSplash= findViewById(R.id.ivSplash);

        //load Animations
        text0= AnimationUtils.loadAnimation(this,R.anim.text0);
        text1= AnimationUtils.loadAnimation(this,R.anim.text1);
        text2= AnimationUtils.loadAnimation(this,R.anim.text2);

        //passing animation
        ivSplash.startAnimation(text0);
        tvSplash.startAnimation(text1);
        tvSubSplash.startAnimation(text1);
        timerButton.startAnimation(text2);
        timerBack.startAnimation(text2);
        //passing event
        timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(timerDashboard.this, Timer.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        timerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(timerDashboard.this,Dashboard.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }
}