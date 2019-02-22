package com.turtleriot.acciones;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.turtleriot.InfoAccionesActivity;
import com.turtleriot.R;
import com.turtleriot.fbDataBase.FireDataBase;
import com.turtleriot.javaBean.Accion;
import com.turtleriot.javaBean.BuscarAccionesAdaptador;

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

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Accion accion = listaAcciones.get(rvBuscarAcciones.getChildAdapterPosition(v));
                Intent i = new Intent(getContext(),InfoAccionesActivity.class);
                i.putExtra("ACCION",accion);
                startActivity(i);
            }
        });

        fdb = new FireDataBase();
        fdb.setListaAcciones(listaAcciones);
        fdb.setAdaptador(adaptador);

        fdb.arrancarChildItemListener();

        rvBuscarAcciones.setLayoutManager(llm);
        rvBuscarAcciones.setAdapter(adaptador);
        rvBuscarAcciones.setItemAnimator(new DefaultItemAnimator());

        return v;
    }
}
