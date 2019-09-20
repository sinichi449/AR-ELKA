package com.smkn1turen.belajarelektronik;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import com.smkn1turen.belajarelektronik.ui.Info;
import com.smkn1turen.belajarelektronik.ui.MateriPembelajaran;
import com.smkn1turen.belajarelektronik.ui.SKKDActivity;
import com.smkn1turen.belajarelektronik.ui.Soal;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Set native status bar color on Lollipop or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.skyblue));
        }

        // SKKD Intent
        ImageView imgSkkd = findViewById(R.id.img_skkd);
        imgSkkd.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, SKKDActivity.class);
            ActivityOptions options =
                    ActivityOptions.makeCustomAnimation(MainActivity.this, android.R.anim.slide_in_left,
                            android.R.anim.slide_out_right);
            startActivity(myIntent, options.toBundle());
        });


        // AR Intent
        ImageView imgAr = findViewById(R.id.img_ar);
        imgAr.setOnClickListener(v -> {
            // TODO: AR Event Handler
            startActivity(new Intent(MainActivity.this, UnityPlayerActivity.class));
        });

        // Materi Pelajaran Intent
        ImageView imgMateriPelajaran = findViewById(R.id.img_materi_pelajaran);
        imgMateriPelajaran.setOnClickListener(v -> {
            ActivityOptions options = ActivityOptions.makeCustomAnimation(MainActivity.this, android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
            startActivity(new Intent(MainActivity.this, MateriPembelajaran.class), options.toBundle());
        });

        // Soal-soal Intent
        ImageView imgSoal = findViewById(R.id.img_soal);
        imgSoal.setOnClickListener(v -> {
            ActivityOptions options = ActivityOptions.makeCustomAnimation(
                    MainActivity.this, android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
            startActivity(new Intent(MainActivity.this, Soal.class), options.toBundle());
        });

        // Petujuk Intent
        ImageView imgPetunjuk = findViewById(R.id.img_petunjuk);
        imgPetunjuk.setOnClickListener(v -> {
            // TODO: Petunjuk Event Handler
        });

        // Info Intent
        ImageView imgTentang = findViewById(R.id.img_tentang);
        imgTentang.setOnClickListener(v -> {
            ActivityOptions options = ActivityOptions.makeCustomAnimation(MainActivity.this,
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
            startActivity(new Intent(MainActivity.this, Info.class), options.toBundle());
        });

        // Back Button (Exit)
        ImageView imgBack = findViewById(R.id.img_back);
        imgBack.setOnClickListener(v -> finish());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
