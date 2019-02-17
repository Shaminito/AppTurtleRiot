package com.example.a21746033.appturtleriot.acciones;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a21746033.appturtleriot.R;
import com.example.a21746033.appturtleriot.fbDataBase.FireDataBase;
import com.example.a21746033.appturtleriot.javaBean.Accion;
import com.example.a21746033.appturtleriot.javaBean.BuscarAccionesAdaptador;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarAccionesFragment extends Fragment {

    private View v;

    private RecyclerView rvBuscarAcciones;

    ArrayList<Accion> listaAcciones;
    LinearLayoutManager llm;
    BuscarAccionesAdaptador adaptador;

    // DATABASE
    private FireDataBase fdb;

    public BuscarAccionesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_buscar_acciones, container, false);

        rvBuscarAcciones = v.findViewById(R.id.rvBuscarAcciones);

        listaAcciones = new ArrayList<>();
        llm = new LinearLayoutManager(getActivity());
        adaptador = new BuscarAccionesAdaptador(listaAcciones);

        fdb.setListaAcciones(listaAcciones);
        fdb.setAdaptador(adaptador);

        fdb.arrancarChildItemListener();

        rvBuscarAcciones.setLayoutManager(llm);
        rvBuscarAcciones.setAdapter(adaptador);
        rvBuscarAcciones.setItemAnimator(new DefaultItemAnimator());

        return v;
    }

    public void setFdb(FireDataBase fdb) {
        this.fdb = fdb;
    }
}
