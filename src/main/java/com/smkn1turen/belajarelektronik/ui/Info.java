package com.smkn1turen.belajarelektronik.ui;

import android.os.Bundle;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;
import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.constant.UniversalSetter;

import androidx.appcompat.app.AppCompatActivity;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // Set status bar color to orange
        UniversalSetter.setOrangeStatusBar(getWindow(), getResources());

        // Set PDF asset
        PDFView pdfView = findViewById(R.id.pdfViewPetunjuk);
        pdfView.fromAsset("info.pdf")
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .enableAntialiasing(true)
                .load();

//         Set back button on toolbar behaviour
        ImageView imgBack = findViewById(R.id.img_back_from_info);
        UniversalSetter.backToMainWithSlide(imgBack, this);
    }
}
