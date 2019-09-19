package com.smkn1turen.belajarelektronik.splash;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.VideoView;

import com.smkn1turen.belajarelektronik.MainActivity;
import com.smkn1turen.belajarelektronik.R;

public class SplashKeduaRumahBelajar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_kedua_rumah_belajar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        try {
            VideoView videoView = findViewById(R.id.videoView);
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash_dua);
            videoView.setVideoURI(uri);
            videoView.setZOrderOnTop(true);
            videoView.start();

            videoView.setOnCompletionListener(mp -> jump());
        } catch (Exception e) {
            jump();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        jump();
        return true;
    }

    private void jump() {
        if (isFinishing()) {
            return;
        }
        Intent myIntent = new Intent(this, MainActivity.class);
        ActivityOptions options =
                ActivityOptions.makeCustomAnimation(this, android.R.anim.fade_in,
                        android.R.anim.fade_out);
        startActivity(myIntent, options.toBundle());
        finish();
    }
}
