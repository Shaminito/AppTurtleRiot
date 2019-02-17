package com.example.a21746033.appturtleriot.acciones;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.a21746033.appturtleriot.AccionesFragment;
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

    private RelativeLayout rlFragmentContent;

    private FireDataBase fdb;

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

        rlFragmentContent = getActivity().findViewById(R.id.rlFragmentContent);

        //fdb = new FireDataBase();

        c_ivFotoACC();
        c_ivPlayaACC();
        c_ivCrearAcciones();

        return v;
    }

    public void setFdb(FireDataBase fdb) {
        this.fdb = fdb;
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
                //CREAR UNA NUEVA ACCION PARA EL FIREBASE

                //NOMBRE
                String propietario = getActivity().getIntent().getStringExtra("USER");
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
                if(verificarAccion()){
                    fdb.guardarAccion(new Accion(propietario,titulo,fecha,descripcion));

                    rlFragmentContent.removeAllViews();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.rlFragmentContent,new AccionesFragment());
                    ft.commit();
                }
                else{
                    Toast.makeText(getActivity(),getString(R.string.toast_AccionVacio),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean verificarAccion() {
        if(etTituloACC.getText().toString().isEmpty() || etFechaACC.getText().toString().isEmpty() || etDescripcionACC.getText().toString().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
}