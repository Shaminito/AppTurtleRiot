package com.example.a21746033.appturtleriot;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PantallaInicioFragment extends Fragment {

    private View v;

    private TextView tvTitulo;
    private LinearLayout llMain;
    private Button btnConectar;
    private TextView tvNuevaCuenta;

    public PantallaInicioFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_pantalla_inicio,container, false);

        tvTitulo = v.findViewById(R.id.tvTITULO);
        llMain = v.findViewById(R.id.llMain);
        btnConectar = v.findViewById(R.id.btnSignIn);
        tvNuevaCuenta = v.findViewById(R.id.tvNuevaCuenta);

        Animation myanim = AnimationUtils.loadAnimation(v.getContext(), R.anim.anim_pantalla_inicio);

        tvTitulo.startAnimation(myanim);
        llMain.startAnimation(myanim);

        c_btnConectar();
        c_tvNuevaCuneta();

        return v;
    }

    private void c_btnConectar() {
        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO CONECTAR
            }
        });
    }

    private void c_tvNuevaCuneta() {
        tvNuevaCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(v.getContext(),RegisterUserActivity.class);
                v.getContext().startActivity(i);
            }
        });
    }
}