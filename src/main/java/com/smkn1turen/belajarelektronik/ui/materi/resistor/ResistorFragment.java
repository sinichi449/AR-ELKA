package com.smkn1turen.belajarelektronik.ui.materi.resistor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.constant.UniversalSetter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ResistorFragment extends Fragment {

    public ResistorFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_resistor, container, false);

        UniversalSetter.setPdfView(root, R.id.pdfView, "resistor.pdf");

        return root;
    }
}