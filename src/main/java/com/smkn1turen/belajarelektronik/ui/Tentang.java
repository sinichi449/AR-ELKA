package com.smkn1turen.belajarelektronik.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.constant.SetBasicAppearance;

public class Tentang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        SetBasicAppearance.setOrangeStatusBar(getWindow(), getResources());

        ImageView imgBack = findViewById(R.id.img_back_from_tentang);
        SetBasicAppearance.backToMainWithSlide(imgBack, this);
    }
}
