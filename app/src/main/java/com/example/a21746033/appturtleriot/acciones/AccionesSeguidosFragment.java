package com.example.a21746033.appturtleriot.acciones;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a21746033.appturtleriot.R;
import com.example.a21746033.appturtleriot.fbDataBase.FireDataBase;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccionesSeguidosFragment extends Fragment {

    private View v;

    private FireDataBase fdb;

    public AccionesSeguidosFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_acciones_seguidos, container, false);
        return v;
    }

    public void setFdb(FireDataBase fdb) {
        this.fdb = fdb;
    }
}
