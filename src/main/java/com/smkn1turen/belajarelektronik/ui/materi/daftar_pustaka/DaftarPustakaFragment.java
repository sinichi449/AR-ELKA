package com.smkn1turen.belajarelektronik.ui.materi.daftar_pustaka;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.barteksc.pdfviewer.PDFView;
import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.constant.SetBasicAppearance;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaftarPustakaFragment extends Fragment {

    private PDFView pdfView;

    public DaftarPustakaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_daftar_pustaka, container, false);

        SetBasicAppearance.setPdfView(root, R.id.pdfView, "daftar_pustaka.pdf");

        return root;
    }

}
