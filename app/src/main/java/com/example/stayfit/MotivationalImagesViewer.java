package com.example.stayfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MotivationalImagesViewer extends AppCompatActivity {
    private RecyclerView mrecyclerView;
    private RequestQueue requestQueue;
    private List<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivational_images_viewer);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        mrecyclerView=findViewById(R.id.recyclerView);
        mrecyclerView.setHasFixedSize(true);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue=VolleySingleton.getInstance(this).getRequestQueue();

        itemList=new ArrayList<>();

        fetchData();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent b = new Intent(MotivationalImagesViewer.this,Dashboard.class);
                        startActivity(b);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_video:
                        Intent a = new Intent(MotivationalImagesViewer.this,FitnessVideosPlayer.class);
                        startActivity(a);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_image:

                        break;
                    case R.id.navigation_songs:
                        Intent c = new Intent(MotivationalImagesViewer.this,FitnessMusicPlayer.class);
                        startActivity(c);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_profile:
                        Intent d = new Intent(MotivationalImagesViewer.this,myProfileActivity.class);
                        startActivity(d);
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
            }
        });
    }
    private void fetchData() {
        String url1 = "https://pixabay.com/api/?key=22174680-67b586530fbd21431bb2f114f&q=quotes&image_type=photo&pretty=true";
        String url2 = "https://pixabay.com/api/?key=22174680-67b586530fbd21431bb2f114f&q=fitness&image_type=photo&pretty=true";
        String url3 = "https://pixabay.com/api/?key=22174680-67b586530fbd21431bb2f114f&q=motivational+quotes&image_type=photo&pretty=true";
        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("hits");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String imageUrl = jsonObject.getString("webformatURL");
                        int likes = jsonObject.getInt("likes");
                        String tags = jsonObject.getString("tags");

                        Item posts = new Item(imageUrl, tags, likes);

                        itemList.add(posts);
                    }
                    PostAdapter adapter = new PostAdapter(MotivationalImagesViewer.this, itemList);
                    mrecyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.GET, url2, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("hits");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String imageUrl = jsonObject.getString("webformatURL");
                        int likes = jsonObject.getInt("likes");
                        String tags = jsonObject.getString("tags");

                        Item posts = new Item(imageUrl, tags, likes);

                        itemList.add(posts);
                    }
                    PostAdapter adapter = new PostAdapter(MotivationalImagesViewer.this, itemList);
                    mrecyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        JsonObjectRequest jsonObjectRequest3 = new JsonObjectRequest(Request.Method.GET, url3, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("hits");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String imageUrl = jsonObject.getString("webformatURL");
                        int likes = jsonObject.getInt("likes");
                        String tags = jsonObject.getString("tags");

                        Item posts = new Item(imageUrl, tags, likes);

                        itemList.add(posts);
                    }
                    PostAdapter adapter = new PostAdapter(MotivationalImagesViewer.this, itemList);
                    mrecyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonObjectRequest3);
        requestQueue.add(jsonObjectRequest2);
        requestQueue.add(jsonObjectRequest1);
    }
}