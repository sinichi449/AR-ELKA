package com.smkn1turen.belajarelektronik.ui;

import android.os.Bundle;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;
import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.constant.UniversalSetter;

import androidx.appcompat.app.AppCompatActivity;

public class PetunjukActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk);

        UniversalSetter.setBlueStatusBar(getWindow(), getResources());

        PDFView pdfView = findViewById(R.id.pdfViewPetunjuk);
        pdfView.fromAsset("petunjuk.pdf")
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .enableAntialiasing(true)
                .load();

        ImageView imgBack = findViewById(R.id.img_back_from_info);
        UniversalSetter.backToMainWithSlide(imgBack, this);
    }
}
