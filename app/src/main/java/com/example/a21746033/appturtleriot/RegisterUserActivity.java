package com.example.a21746033.appturtleriot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterUserActivity extends AppCompatActivity {


    //AUTENTICACION

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public static final int RC_SIGN_IN = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        getSupportActionBar().hide();
    }

    public void c_btnRegistrar(View v){

    }
}
