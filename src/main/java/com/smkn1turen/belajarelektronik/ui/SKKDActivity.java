package com.smkn1turen.belajarelektronik.ui;

import android.os.Bundle;
import android.widget.ImageView;

import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.constant.UniversalSetter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SKKDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skkd);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        // Set android native status bar to be matched with current toolbar color
        UniversalSetter.setBlueStatusBar(getWindow(), getResources());

        // Go back to MainActivity
        ImageView imgBack = findViewById(R.id.btn_back_from_silabus);
        UniversalSetter.backToMainWithSlide(imgBack, this);
    }
}
