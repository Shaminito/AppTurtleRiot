package com.example.a21746033.appturtleriot;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

import com.example.a21746033.appturtleriot.javaBean.UsuarioPojo;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Arrays;

public class PantallaInicioFragment extends Fragment {

    private View v;
    ArrayList<UsuarioPojo> datos;
    private TextView tvTitulo;
    private LinearLayout llMain;
    private Button btnConectar;
    private TextView tvNuevaCuenta;

    //Storage
    private DatabaseReference dbR;
    private ChildEventListener cel;
    private String usuario;

    public PantallaInicioFragment() {}


    //AUTENTICACION

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public static final int RC_SIGN_IN = 1;

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

        datos = new ArrayList<UsuarioPojo>();



        c_btnConectar();
        c_tvNuevaCuneta();
        mFirebaseAuth = FirebaseAuth.getInstance();


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                if (user != null) { // el usuario está logado
                    Toast.makeText(v.getContext(), "Ya estás logado. Bienvenido!", Toast.LENGTH_SHORT).show();
                    usuario = user.getEmail();  //usuario, autenticacion mediante email.
                    AnadirChildEventListener(); // nos aseguramos que se asigna el listener a la referencia de la base de datos

                } else {
                    // usuario = "NO REGISTRADO / ANONIMO.";

                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build()))
                                    .setTheme(R.style.AppTheme)
                                    .build(), RC_SIGN_IN);
                }
            }
        };
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
        return v;
    }


    private void AnadirChildEventListener() {
        if (cel == null) {
            cel = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    System.out.println("Nuevo mensaje");
                    UsuarioPojo m = dataSnapshot.getValue(UsuarioPojo.class);
                    datos.add(m);

                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    System.out.println("Mensaje Modificado.");
                    UsuarioPojo m = dataSnapshot.getValue(UsuarioPojo.class);

                    int pos = 0;
                    for (int i = 0; i < datos.size(); i++) {
                        if (datos.get(i).getUser().equals(m.getUser())) {
                            datos.set(i, m);
                            pos = i;
                        }
                    }
                }


                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    System.out.println("Mensaje borrado: " + dataSnapshot.getValue(UsuarioPojo.class).getUser());
                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };

            dbR.addChildEventListener(cel);
        }
    }


    private void c_btnConectar() {
        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usuario != null) {
                    //TO-DO
                }
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