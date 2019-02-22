package com.turtleriot;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.turtleriot.R;
import com.turtleriot.acciones.AccionesSeguidosFragment;
import com.turtleriot.acciones.AdministrarAccionesFragment;
import com.turtleriot.acciones.BuscarAccionesFragment;
import com.turtleriot.acciones.CrearAccionesFragment;

public class AccionesFragment extends Fragment {

    private View v;

    private LinearLayout llBuscarAcciones;
    private LinearLayout llAccionesSeguidos;
    private LinearLayout llCrearAcciones;
    private LinearLayout llAdministrarAcciones;

    //private FireDataBase fdb;

    public AccionesFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_acciones, container, false);

        llBuscarAcciones = v.findViewById(R.id.llBuscarAcciones);
        llAccionesSeguidos = v.findViewById(R.id.llAccionesSeguidos);
        llCrearAcciones = v.findViewById(R.id.llCrearAcciones);
        llAdministrarAcciones = v.findViewById(R.id.llAdministrarAcciones);

        c_llBuscarAcciones();
        c_llAccionesSeguidos();
        c_llCrearAcciones();
        c_llAdministrarAcciones();

        return v;
    }

    //public void setFdb(FireDataBase fdb) {this.fdb = fdb;}

    private void c_llBuscarAcciones() {
        llBuscarAcciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                BuscarAccionesFragment buscarAccionesFragment = new BuscarAccionesFragment();
                //buscarAccionesFragment.setFdb(fdb);

                ft.replace(R.id.rlFragmentContent, buscarAccionesFragment);
                ft.commit();
            }
        });
    }

    private void c_llAccionesSeguidos() {

        llAccionesSeguidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                AccionesSeguidosFragment accionesSeguidosFragment = new AccionesSeguidosFragment();
                //accionesSeguidosFragment.setFdb(fdb);

                ft.replace(R.id.rlFragmentContent, accionesSeguidosFragment);
                ft.commit();
            }
        });
    }

    private void c_llCrearAcciones() {
        llCrearAcciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                CrearAccionesFragment crearAccionesFragment = new CrearAccionesFragment();
                //crearAccionesFragment.setFdb(fdb);

                ft.replace(R.id.rlFragmentContent, crearAccionesFragment);
                ft.commit();
            }
        });
    }

    private void c_llAdministrarAcciones() {
        llAdministrarAcciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                AdministrarAccionesFragment administrarAccionesFragment = new AdministrarAccionesFragment();
                //administrarAccionesFragment.setFdb(fdb);

                ft.replace(R.id.rlFragmentContent, administrarAccionesFragment);
                ft.commit();
            }
        });
    }
}