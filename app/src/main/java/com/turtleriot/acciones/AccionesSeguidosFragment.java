package com.turtleriot.acciones;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turtleriot.R;
import com.turtleriot.fbDataBase.FireDataBase;

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
