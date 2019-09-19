package com.smkn1turen.belajarelektronik.ui.materi.kapasitor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.constant.SetBasicAppearance;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class KapasitorFragment extends Fragment {

    public KapasitorFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_kapasitor, container, false);

        SetBasicAppearance.setPdfView(root, R.id.pdfView, "kapasitor.pdf");

        return root;
    }
}