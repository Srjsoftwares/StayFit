package com.example.stayfit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FitnessMusicPlayer extends AppCompatActivity {
    ImageView gymMotivation,fitnessMotivation,workoutMotivation,edmWorkout,gymMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_music_player);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        gymMotivation=findViewById(R.id.gymMotivation);
        fitnessMotivation=findViewById(R.id.fitnessMotivation);
        workoutMotivation=findViewById(R.id.workoutMotivation);
        edmWorkout=findViewById(R.id.edmWorkout);
        gymMusic=findViewById(R.id.gymMusic);

        gymMotivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://open.spotify.com/playlist/5cAwvaSXeNSrSbmrOUSBzo");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        fitnessMotivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://open.spotify.com/playlist/28nRTAuO50OzDEoP8ioyjz");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        workoutMotivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://open.spotify.com/playlist/2YLYJT19TUBMD4eDQEnivw");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        edmWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://open.spotify.com/playlist/0TsHgCCpifeNJg3d8z3Nfv");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gymMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://open.spotify.com/playlist/7mZZkjpyoY83wHbssEtzNF");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent b = new Intent(FitnessMusicPlayer.this,Dashboard.class);
                        startActivity(b);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_video:
                        Intent a = new Intent(FitnessMusicPlayer.this,FitnessVideosPlayer.class);
                        startActivity(a);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_image:
                        Intent c = new Intent(FitnessMusicPlayer.this,MotivationalImagesViewer.class);
                        startActivity(c);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_songs:
                        break;
                    case R.id.navigation_profile:
                        Intent d = new Intent(FitnessMusicPlayer.this,myProfileActivity.class);
                        startActivity(d);
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
            }
        });

    }
}