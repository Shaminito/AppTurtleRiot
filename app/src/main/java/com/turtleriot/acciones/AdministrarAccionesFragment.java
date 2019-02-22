package com.turtleriot.acciones;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turtleriot.R;
import com.turtleriot.fbDataBase.FireDataBase;

public class AdministrarAccionesFragment extends Fragment {

    private View v;

    private FireDataBase fdb;

    public AdministrarAccionesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_administrar_acciones, container, false);
        return v;
    }

    public void setFdb(FireDataBase fdb) {
        this.fdb = fdb;
    }
}
