package com.example.a21746033.appturtleriot.acciones;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a21746033.appturtleriot.R;

public class AdministrarAccionesFragment extends Fragment {

    private View v;

    public AdministrarAccionesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_administrar_acciones, container, false);
        return v;
    }
}
