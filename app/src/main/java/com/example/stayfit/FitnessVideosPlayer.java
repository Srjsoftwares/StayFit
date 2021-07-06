package com.example.stayfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Vector;

public class FitnessVideosPlayer extends AppCompatActivity {
    RecyclerView recyclerView;
    Vector<YoutubeVideos> youtubeVideosVector=new Vector<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_videos_player);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/u5TyCmvQ1BY\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/D0DoJtmvSPQ\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Ow-WhVU3wZ0\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/1FPCD6Rwquc\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/nFBdDaK_6Ko\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/vHgXavq2s3U\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/55NtOmuZMbc\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/PDD6kDM7svY\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/U1shtj805AE\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/FPANmqfXnTw\" framebolder=\"0\" allowfullscreen></iframe>"));

        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/XtyLfJa3clI\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Qt3ZIwPn_ZA\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/cAo2Ky1ONrU\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/5r8PkdnyfDs\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/SgvCMxYPOFs\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/XvzQkSwwPhg\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/N7G-kGvai4M\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/_BUQUYu-5e0\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/lq6TgH71BSg\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tyn8uGWGGWc\" framebolder=\"0\" allowfullscreen></iframe>"));


        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ggBIyXXSI5M\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/agdif9Q1w4M\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/_zrPmDEMsMc\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/5YQhvKilb80\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Xom0GkLdmJ0\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/W_9gsCbOA2E\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/lgbEwgtjI2s\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Zo9_i-rCnNQ\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/HnoPHqrdXQ8\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/T1XLHsz4r_M\" framebolder=\"0\" allowfullscreen></iframe>"));

        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/fC5vyMERa94\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/5bIgsBCuuB8\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/zkDUui4BI8M\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/sbZRAKf2S1o\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/FO3aglziCxE\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/I3Pqf5FQiZc\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/01OI5lGoMhw\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/x6jmxj7B1VA\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/u0gkkrLptwA\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eT3xIgzbhGM\" framebolder=\"0\" allowfullscreen></iframe>"));

        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/VdQv2dbOJqc\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/T1XLHsz4r_M\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Qn0Xn-lZ0E8\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/WG7BbyvxBMk\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/vK5SoQXvehM\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/PjdpsEW2k7g\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/UVa117ianQQ\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/JpXu8_9G3cY\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/EY2YkXtTxg4\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/te8mslQ-TvY\" framebolder=\"0\" allowfullscreen></iframe>"));

        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tPEQTJm1hs4\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/CIJ9Cq21uwo\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/oA247PQ0too\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/xayWitaHIw4\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/UlqjHQxWtP8\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/O6Xn--gV0_w\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/V2cVjTyHlzY\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/rw9HNlPke-w\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Pa8G2xWel6c\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/sQFRWxKgRKA\" framebolder=\"0\" allowfullscreen></iframe>"));



        VideoAdapter videoAdapter=new VideoAdapter(youtubeVideosVector);
        recyclerView.setAdapter(videoAdapter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent b = new Intent(FitnessVideosPlayer.this,Dashboard.class);
                        startActivity(b);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_video:
                        break;
                    case R.id.navigation_image:
                        Intent c = new Intent(FitnessVideosPlayer.this,MotivationalImagesViewer.class);
                        startActivity(c);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_songs:
                        Intent a = new Intent(FitnessVideosPlayer.this,FitnessMusicPlayer.class);
                        startActivity(a);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_profile:
                        Intent d = new Intent(FitnessVideosPlayer.this,myProfileActivity.class);
                        startActivity(d);
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
            }
        });

    }
}