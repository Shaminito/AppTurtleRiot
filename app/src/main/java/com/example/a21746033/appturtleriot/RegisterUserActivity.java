package com.example.a21746033.appturtleriot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a21746033.appturtleriot.javaBean.UsuarioPojo;

public class RegisterUserActivity extends AppCompatActivity {

    private EditText etRegUserNombre;
    private EditText etRegUserEmail;
    private EditText etPassword;

    private String userNom;
    private String correo;
    private String passwd;

    UsuarioPojo usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        etRegUserEmail = findViewById(R.id.etRegUserEmail);
        etPassword = findViewById(R.id.etPassword);
        etRegUserNombre = findViewById(R.id.etRegUserNombre);

        getSupportActionBar().hide();
    }

    public void c_btnRegistrar(View v){
        if(etRegUserNombre.getText().toString().isEmpty()){
            userNom = "ANONIMO";
        }
        else{
            userNom = etRegUserNombre.getText().toString().trim();
        }
        correo = etRegUserEmail.getText().toString().trim();
        passwd = etPassword.getText().toString().trim();
        usuario = new UsuarioPojo(userNom, correo, passwd);
        if(verificarDatos()){
            Intent i = getIntent();
            i.putExtra(getString(R.string.REG_USUARIO),usuario);
            setResult(RESULT_OK,i);
            finish();
        }
        else if(!verificarDatos()){
            Toast.makeText(this,getString(R.string.toast_verifData),Toast.LENGTH_SHORT).show();
        }
        else{
            setResult(RESULT_CANCELED);
            finish();
        }
    }

    private boolean verificarDatos() {
        if (correo.isEmpty() || passwd.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}