package com.example.a21746033.appturtleriot;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a21746033.appturtleriot.autenticacion.Autenticacion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PantallaInicioFragment extends Fragment {

    private View v;

    private TextView tvTitulo;
    private LinearLayout llMain;

    private Button btnConectar;
    private TextView tvNuevaCuenta;

    private Autenticacion autenticacion;

    private EditText etLoginUser;
    private EditText etLoginPasswd;

    public static final int REGISTRAR_CUENTA = 1;

    public PantallaInicioFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_pantalla_inicio,container, false);

        autenticacion = new Autenticacion();

        tvTitulo = v.findViewById(R.id.tvTITULO);
        llMain = v.findViewById(R.id.llMain);
        btnConectar = v.findViewById(R.id.btnSignIn);
        tvNuevaCuenta = v.findViewById(R.id.tvNuevaCuenta);
        etLoginUser = v.findViewById(R.id.etLoginUser);
        etLoginPasswd = v.findViewById(R.id.etLoginPasswd);

        Animation myanim = AnimationUtils.loadAnimation(v.getContext(), R.anim.anim_pantalla_inicio);

        tvTitulo.startAnimation(myanim);
        llMain.startAnimation(myanim);

        c_btnConectar();
        c_tvNuevaCuenta();

        return v;
    }

    private void c_btnConectar() {
        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autenticacion.obtenerCuenta(etLoginUser.getText().toString().trim(), etLoginPasswd.getText().toString().trim());
                autenticarUsuario();
            }

            private void autenticarUsuario() {
                if(autenticacion.validarDatos()){
                    autenticacion.getFba().signInWithEmailAndPassword(etLoginUser.getText().toString().trim(), etLoginPasswd.getText().toString().trim()).addOnCompleteListener((Activity) v.getContext(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                autenticacion.setUser(autenticacion.getFba().getCurrentUser());
                                Intent i = new Intent(getContext(),PortadaManuActivity.class);
                                //i.putExtra("USER",autenticacion.getUser().getEmail());
                                startActivity(i);
                            } else {
                                Toast.makeText(getContext(), getString(R.string.toast_no_accede), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(getContext(),getString(R.string.toast_no_accede),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void c_tvNuevaCuenta() {
        tvNuevaCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(v.getContext(),RegisterUserActivity.class);
                startActivityForResult(i,REGISTRAR_CUENTA);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //TODO
    }
}