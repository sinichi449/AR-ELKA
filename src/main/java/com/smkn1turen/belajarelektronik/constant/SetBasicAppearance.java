package com.smkn1turen.belajarelektronik.constant;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;
import com.smkn1turen.belajarelektronik.MainActivity;
import com.smkn1turen.belajarelektronik.R;

public class SetBasicAppearance {

    public static void setOrangeStatusBar(Window window, Resources resources) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(resources.getColor(R.color.orange));
        }
    }

    public static void setBlueStatusBar(Window window, Resources resources) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(resources.getColor(R.color.skyblue));
        }
    }

    public static void backToMainWithSlide(ImageView imgBack, final Context context) {
        imgBack.setOnClickListener(v -> {
            Intent myIntent = new Intent(context, MainActivity.class);
            ActivityOptions options =
                    ActivityOptions.makeCustomAnimation(context, android.R.anim.slide_in_left,
                            android.R.anim.slide_out_right);
            context.startActivity(myIntent, options.toBundle());
            ((Activity)context).finish();
        });
    }

    public static void setPdfView(View view, int pdfViewId, String asset) {
        PDFView pdfView;
        pdfView = view.findViewById(pdfViewId);
        pdfView.fromAsset(asset)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .enableAntialiasing(true)
                .load();
    }
}
