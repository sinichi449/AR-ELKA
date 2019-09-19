package com.smkn1turen.belajarelektronik.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.smkn1turen.belajarelektronik.R;

public class SplashApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_app);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent = new Intent(SplashApp.this, SplashPertamaKemendikbud.class);
                ActivityOptions options =
                        ActivityOptions.makeCustomAnimation(SplashApp.this, android.R.anim.fade_in,
                                android.R.anim.fade_out);
                startActivity(myIntent, options.toBundle());
                finish();
            }
        },1700);
    }
}
