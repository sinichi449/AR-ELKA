package com.smkn1turen.belajarelektronik.ui.materi.dasar_elektronika;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.github.barteksc.pdfviewer.PDFView;
import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.constant.SetBasicAppearance;

public class DasarElektronikaFragment extends Fragment {

    private PDFView pdfView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dasar_elektronika, container, false);

        pdfView = root.findViewById(R.id.pdfView);
        SetBasicAppearance.setPdfView(root, R.id.pdfView, "dasar.pdf");

        return root;
    }
}