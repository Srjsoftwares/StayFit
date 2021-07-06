package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.jaeger.library.StatusBarUtil;

public class SplashScreen extends AppCompatActivity {
    ImageView splashImg;
    Animation text0,text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        splashImg= findViewById(R.id.splashImg);

        //load animation
        text0= AnimationUtils.loadAnimation(this,R.anim.text0);

        //call animation
        splashImg.startAnimation(text0);

        StatusBarUtil.setTransparent(this);

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                Intent i = new Intent(SplashScreen.this, Dashboard.class);
                startActivity(i);
                finish(); } }, 3000);
    }
}