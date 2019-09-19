package com.smkn1turen.belajarelektronik.ui.materi.dioda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.constant.SetBasicAppearance;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class DiodaFragment extends Fragment {

    public DiodaFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dioda, container, false);

        SetBasicAppearance.setPdfView(root, R.id.pdfView, "dioda.pdf");

        return root;
    }
}