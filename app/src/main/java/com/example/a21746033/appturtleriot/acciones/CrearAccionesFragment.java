package com.example.a21746033.appturtleriot.acciones;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.a21746033.appturtleriot.R;
import com.example.a21746033.appturtleriot.fbDataBase.FireDataBase;
import com.example.a21746033.appturtleriot.javaBean.Accion;

public class CrearAccionesFragment extends Fragment {

    private View v;

    private EditText etTituloACC;
    private ImageView ivFotoACC;
    private ImageView ivPlayaACC;
    private EditText etFechaACC;
    private EditText etDescripcionACC;

    private ImageView ivCrearAcciones;

    private FireDataBase fdb;
    /*
    private String usuario;

    private EditText etTituloACC;
    private EditText etDescripcionACC;
    private EditText etUbicacionACC;
    private EditText etFechaACC;

    private LinearLayout llSubirFoto;
    private ImageView ivCrearAccion;

    private FireDataBase fdb;
     */

    public CrearAccionesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_crear_acciones, container, false);

        etTituloACC = v.findViewById(R.id.etTituloACC);
        ivFotoACC = v.findViewById(R.id.ivFotoACC);
        ivPlayaACC = v.findViewById(R.id.ivPlayaACC);
        etFechaACC = v.findViewById(R.id.etFechaACC);
        etDescripcionACC = v.findViewById(R.id.etDescripcionACC);

        ivCrearAcciones = v.findViewById(R.id.ivCrearAcciones);

        fdb = new FireDataBase();

        c_ivFotoACC();
        c_ivPlayaACC();
        c_ivCrearAcciones();
        /*
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
         */

        return v;
    }

    private void c_ivFotoACC() {
        ivFotoACC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO SUBIR IMAGEN
            }
        });
    }

    private void c_ivPlayaACC() {
        ivPlayaACC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO OBTENER PLAYA
            }
        });
    }

    private void c_ivCrearAcciones() {
        ivCrearAcciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO CREAR UNA NUEVA ACCION PARA EL FIREBASE

                //NOMBRE
                String propietario = getActivity().getIntent().getStringExtra("USER");
                propietario = propietario.replace(".","");
                //TITULO
                String titulo = etTituloACC.getText().toString();
                //FOTO
                //Drawable foto =
                //PLAYA
                //Playa playa =
                //FECHA
                String fecha = etFechaACC.getText().toString();
                //DESCRIPCIÓN
                String descripcion = etDescripcionACC.getText().toString();

                fdb.guardarAccion(new Accion(propietario,titulo,fecha,descripcion));
            }
        });
    }
    /*
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
     */
}