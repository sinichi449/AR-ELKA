package com.smkn1turen.belajarelektronik.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.constant.SetBasicAppearance;

public class Soal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);

        // Set android native status bar to be matched with current toolbar color
        SetBasicAppearance.setBlueStatusBar(getWindow(), getResources());

        ImageView imgBack = findViewById(R.id.btn_back_from_soal);
        SetBasicAppearance.backToMainWithSlide(imgBack, this);
    }
}
