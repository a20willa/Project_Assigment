package com.example.projectassigment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        myWebView.loadUrl("https://www.google.com/maps/place/Torn+1,+541+92+Sk%C3%B6vde/@58.4097609,13.9315804,14.63z/data=!4m5!3m4!1s0x465b01141c0050c1:0x4add464d899c0c56!8m2!3d58.4100542!4d13.9342894");
    }
}