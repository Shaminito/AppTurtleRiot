package com.example.a21746033.appturtleriot.acciones;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.a21746033.appturtleriot.AccionesFragment;
import com.example.a21746033.appturtleriot.R;
import com.example.a21746033.appturtleriot.fbDataBase.FireDataBase;
import com.example.a21746033.appturtleriot.javaBean.Accion;

import java.util.Calendar;

public class CrearAccionesFragment extends Fragment {

    private View v;
    private static final String CERO = "0";
    private static final String DOS_PUNTOS = ":";
    private static final String BARRA = "/";


    private TextInputLayout tilTituloACC;
    private ImageView ivFotoACC;
    private ImageView ivPlayaACC;
    private EditText etFechaACC;
    private TextInputLayout tilDescripcionACC;

    public final Calendar ca = Calendar.getInstance();
    //fecha
    final int mes = ca.get(Calendar.MONTH);
    final int dia = ca.get(Calendar.DAY_OF_MONTH);
    final int anio = ca.get(Calendar.YEAR);
    private ImageView ivCrearAcciones;
    //tiempo
    final int hora = ca.get(Calendar.HOUR_OF_DAY);
    final int minuto = ca.get(Calendar.MINUTE);
    //ventanas
    EditText etFecha, etHora;
    ImageButton ibObtenerFecha, ibObtenerHora;



    private RelativeLayout rlFragmentContent;

    private FireDataBase fdb;

    public CrearAccionesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_crear_acciones, container, false);

        tilTituloACC = v.findViewById(R.id.tilTituloACC);
        ivFotoACC = v.findViewById(R.id.ivFotoACC);
        ivPlayaACC = v.findViewById(R.id.ivPlayaACC);
        etFechaACC = v.findViewById(R.id.et_mostrar_fecha_picker);
        tilDescripcionACC = v.findViewById(R.id.tilDescripcionACC);

        ivCrearAcciones = v.findViewById(R.id.ivCrearAcciones);

        rlFragmentContent = getActivity().findViewById(R.id.rlFragmentContent);

        fdb = new FireDataBase();
        etFecha = v.findViewById(R.id.et_mostrar_fecha_picker);
        etHora = v.findViewById(R.id.et_mostrar_hora_picker);

        ibObtenerFecha = v.findViewById(R.id.ib_obtener_fecha);
        ibObtenerHora = v.findViewById(R.id.ib_obtener_hora);


        c_ivFotoACC();
        c_ivPlayaACC();
        c_ivCrearAcciones();
        ib_obtener_fecha ();

        return v;
    }

    private void ib_obtener_fecha() {
        ibObtenerFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recogerFecha();

                {
                }
            }
        });
        ibObtenerHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recogerHora();
            }
        });

    }

    private void recogerHora() {
        TimePickerDialog recogerHora = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                String horaFormateada =  (hourOfDay < 9)? String.valueOf(CERO + hourOfDay) : String.valueOf(hourOfDay);
                String minutoFormateado = (minute < 9)? String.valueOf(CERO + minute):String.valueOf(minute);

                String AM_PM;
                if(hourOfDay < 12) {
                    AM_PM = "a.m.";
                } else {
                    AM_PM = "p.m.";
                }

                etHora.setText(horaFormateada + DOS_PUNTOS + minutoFormateado + " " + AM_PM);
            }

        }, hora, minuto, false);

        recogerHora.show();

    }

    private void recogerFecha() {
        DatePickerDialog recogerfecha = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                final int mesActual = month + 1;

                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);

                etFecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);

            }
        },anio,mes,dia);
        recogerfecha.show();
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
                String titulo = tilTituloACC.getEditText().getText().toString();
                //FOTO
                //Drawable foto =
                //PLAYA
                //Playa playa =
                //FECHA
                String fecha = etFechaACC.getText().toString();
                //DESCRIPCIÓN
                String descripcion = tilDescripcionACC.getEditText().getText().toString();
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
        if(tilTituloACC.getEditText().getText().toString().isEmpty() || etFechaACC.getText().toString().isEmpty() || tilDescripcionACC.getEditText().getText().toString().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }


}