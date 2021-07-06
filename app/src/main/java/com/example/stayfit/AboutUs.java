package com.example.stayfit;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        WebView w = (WebView) findViewById(R.id.webview);

        // loading http://www.google.com url in the the WebView.
        w.loadUrl("file:///android_asset/aboutUsDemo.html");

        // this will enable the javascipt.
        w.getSettings().setJavaScriptEnabled(true);

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        w.setWebViewClient(new WebViewClient());


        /*Element versionElement = new Element();
        versionElement.setTitle("Version "+BuildConfig.VERSION_NAME);

                View aboutPage = new AboutPage(this)
                        .isRTL(false)
                        .setCustomFont(" ") // or Typeface
                        .setImage(R.drawable.notification)
                        .addItem(versionElement)
                        .addGroup("Connect with us")
                        .addEmail("elmehdi.sakout@gmail.com")
                        .addWebsite("https://mehdisakout.com/")
                        .addFacebook("the.medy")
                        .addTwitter("medyo80")
                        .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                        .addPlayStore("com.ideashower.readitlater.pro")
                        .addGitHub("medyo")
                        .addInstagram("medyo80")
                        .create();*/
        //setContentView(aboutPage);

    }
}