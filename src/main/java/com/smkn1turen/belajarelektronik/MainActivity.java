package com.smkn1turen.belajarelektronik;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.smkn1turen.belajarelektronik.ui.MateriPembelajaran;
import com.smkn1turen.belajarelektronik.ui.SKKDActivity;
import com.smkn1turen.belajarelektronik.ui.Soal;
import com.smkn1turen.belajarelektronik.ui.Tentang;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.skyblue));
        }

        // SKKD Event
        ImageView imgSkkd = findViewById(R.id.img_skkd);
        imgSkkd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SKKDActivity.class);
                ActivityOptions options =
                        ActivityOptions.makeCustomAnimation(MainActivity.this, android.R.anim.slide_in_left,
                                android.R.anim.slide_out_right);
                startActivity(myIntent, options.toBundle());
            }
        });


        // AR Event
        ImageView imgAr = findViewById(R.id.img_ar);
        imgAr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: AR Event Handler
            }
        });

        // Materi Pelajaran Event
        ImageView imgMateriPelajaran = findViewById(R.id.img_materi_pelajaran);
        imgMateriPelajaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptions options = ActivityOptions.makeCustomAnimation(MainActivity.this, android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);
                startActivity(new Intent(MainActivity.this, MateriPembelajaran.class), options.toBundle());
            }
        });

        // Soal-soal Event
        ImageView imgSoal = findViewById(R.id.img_soal);
        imgSoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptions options = ActivityOptions.makeCustomAnimation(
                        MainActivity.this, android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);
                startActivity(new Intent(MainActivity.this, Soal.class), options.toBundle());
            }
        });

        // Petujuk Event
        ImageView imgPetunjuk = findViewById(R.id.img_petunjuk);
        imgPetunjuk.setOnClickListener(v -> {
            // TODO: Petunjuk Event Handler
        });

        // Tentang
        ImageView imgTentang = findViewById(R.id.img_tentang);
        imgTentang.setOnClickListener(v -> {
            ActivityOptions options = ActivityOptions.makeCustomAnimation(MainActivity.this,
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
            startActivity(new Intent(MainActivity.this, Tentang.class), options.toBundle());
        });

        // Back Button (Exit)
        ImageView imgBack = findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
