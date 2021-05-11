package com.example.projectassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //Skapa och sätt WebView inehåll
        WebView webView = new WebView(this);
        setContentView(webView);
        webView.loadUrl("file:///android_asset/about.html");
    }
}