package com.smkn1turen.belajarelektronik.ui.materi.induktor;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.constant.UniversalSetter;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class InduktorFragment extends Fragment {


    public InduktorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_induktor, container, false);

        UniversalSetter.setPdfView(root, R.id.pdfView, "induktor.pdf");

        return root;
    }

}
