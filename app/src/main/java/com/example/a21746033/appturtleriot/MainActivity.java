package com.example.a21746033.appturtleriot;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /*//BASE DATOS

    private DatabaseReference dbR;
    private ChildEventListener cel;

    //AUTENTICACION FIREBASE

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener cel;
    public static final int RC_SING_IN=1;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.rlMain, new SplashScreenFragment());
        ft.commit();

        abrirPantallaInicio();
        getSupportActionBar().hide(); //esconde el appMenu


        //
        // dbR = FirebaseDatabase.getInstance().getReference().child("Mensaje");
        // AnadirChildEventListener();
    }

    private void abrirPantallaInicio() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentManager fm2 = getSupportFragmentManager();
                FragmentTransaction ft2 = fm2.beginTransaction();
                ft2.replace(R.id.rlMain, new PantallaInicioFragment());
                ft2.commit();
            }
        }, 5300);
    }
}


//CHILDEVENTLISTENER
/*
    private void AnadirChildEventListener(){
        if(cel == null){

            cel = new ChildEventListener(){
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    System.out.println("Nuevo usuario creado");
                    user user = dataSnapshot.getValue(UsuarioPojo.class);
                    datos.add(user);
                    adapter.notifyItemInserted(datos.size()-1);
            }
        }
    }


}*/
