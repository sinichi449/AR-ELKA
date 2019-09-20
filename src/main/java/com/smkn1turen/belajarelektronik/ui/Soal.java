package com.smkn1turen.belajarelektronik.ui;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.constant.UniversalSetter;

import androidx.appcompat.app.AppCompatActivity;

public class Soal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);

        // Set android native status bar to be matched with current toolbar color
        UniversalSetter.setBlueStatusBar(getWindow(), getResources());

        // WEB View with .htm file view
        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/soal.htm"); // Load file from assets
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable javascript
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        // Set back button on toolbar behaviour
        ImageView imgBack = findViewById(R.id.btn_back_from_soal);
        UniversalSetter.backToMainWithSlide(imgBack, this);
    }
}
