package com.example.a21746033.appturtleriot.acciones;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a21746033.appturtleriot.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarAccionesFragment extends Fragment {

    private View v;

    public BuscarAccionesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_buscar_acciones, container, false);
        return v;
    }

}
