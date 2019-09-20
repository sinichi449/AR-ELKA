package com.smkn1turen.belajarelektronik.ui;

import android.os.Bundle;
import android.widget.ImageView;

import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.constant.SetBasicAppearance;

import androidx.appcompat.app.AppCompatActivity;

public class Tentang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        // Set status bar color to orange
        SetBasicAppearance.setOrangeStatusBar(getWindow(), getResources());

        // Set back button on toolbar behaviour
        ImageView imgBack = findViewById(R.id.img_back_from_tentang);
        SetBasicAppearance.backToMainWithSlide(imgBack, this);
    }
}
