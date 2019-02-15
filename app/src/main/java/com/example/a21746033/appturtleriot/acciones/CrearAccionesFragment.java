package com.example.a21746033.appturtleriot.acciones;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.a21746033.appturtleriot.R;
import com.example.a21746033.appturtleriot.fbDataBase.FireDataBase;
import com.example.a21746033.appturtleriot.javaBean.Playas;

public class CrearAccionesFragment extends Fragment {

    private View v;

    private String usuario;

    private EditText etTituloACC;
    private EditText etDescripcionACC;
    private EditText etUbicacionACC;
    private EditText etFechaACC;

    private LinearLayout llSubirFoto;
    private ImageView ivCrearAccion;

    private FireDataBase fdb;

    public CrearAccionesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_crear_acciones, container, false);

        etTituloACC = v.findViewById(R.id.etTituloACC);
        etDescripcionACC = v.findViewById(R.id.etDescripcionACC);
        etUbicacionACC = v.findViewById(R.id.etUbicacionACC);
        etFechaACC = v.findViewById(R.id.etFecha);

        llSubirFoto = v.findViewById(R.id.llSubirFoto);
        ivCrearAccion = v.findViewById(R.id.ivCrearAcciones);

        usuario = getActivity().getIntent().getStringExtra("USER");

        fdb = new FireDataBase();

        c_llSubirFoto();
        c_ivCrearAccion();

        return v;
    }

    private void c_llSubirFoto() {
        llSubirFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO SUBIR FOTO
            }
        });
    }

    private void c_ivCrearAccion() {
        ivCrearAccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificarAccion()){
                    Playas playa = new Playas(etTituloACC.getText().toString(),etDescripcionACC.getText().toString(),etUbicacionACC.getText().toString(),etFechaACC.getText().toString());
                    fdb.crearAccion(usuario, playa);
                }
            }
        });
    }

    private boolean verificarAccion() {
        if(!(etTituloACC.getText().toString().isEmpty() && etDescripcionACC.getText().toString().isEmpty() && etUbicacionACC.getText().toString().isEmpty() && etFechaACC.getText().toString().isEmpty())){
            return true;
        }
        else return false;
    }
}