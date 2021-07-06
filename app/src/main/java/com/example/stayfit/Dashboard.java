package com.example.stayfit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {

    TextView stayfit_logo,introText;
    Button Alarm, StopWatch, Timer;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finish();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        Alarm = findViewById(R.id.Alarm);
        StopWatch = findViewById(R.id.StopWatch);
        Timer = findViewById(R.id.Timer);
        stayfit_logo = findViewById(R.id.stayfit_logo);
        introText = findViewById(R.id.introText);

        //load animation
        Animation text0 = AnimationUtils.loadAnimation(this, R.anim.text0);
        Animation text2 = AnimationUtils.loadAnimation(this, R.anim.text2);


        //passing animation
        stayfit_logo.startAnimation(text0);
        introText.startAnimation(text0);
        Alarm.startAnimation(text2);
        StopWatch.startAnimation(text2);
        Timer.startAnimation(text2);


        Alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Dashboard.this, Alarm.class);
                startActivity(a);

            }
        });

        StopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Dashboard.this, StopWatchActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Dashboard.this, timerDashboard.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        break;
                    case R.id.navigation_video:
                        Intent a = new Intent(Dashboard.this,FitnessVideosPlayer.class);
                        startActivity(a);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_image:
                        Intent b = new Intent(Dashboard.this,MotivationalImagesViewer.class);
                        startActivity(b);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_songs:
                        Intent c = new Intent(Dashboard.this,FitnessMusicPlayer.class);
                        startActivity(c);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_profile:
                        Intent d = new Intent(Dashboard.this,myProfileActivity.class);
                        startActivity(d);
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
            }
        });
    }
}

