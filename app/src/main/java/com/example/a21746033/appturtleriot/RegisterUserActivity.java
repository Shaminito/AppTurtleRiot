package com.example.a21746033.appturtleriot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUserActivity extends AppCompatActivity {

    //private EditText etRegUserNombre;
    private EditText etRegUserEmail;
    private EditText etRegUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        etRegUserEmail = findViewById(R.id.etRegUserEmail);
        etRegUserPassword = findViewById(R.id.etPassword);

        getSupportActionBar().hide();
    }

    public void c_btnRegistrar(View v){
        if(verificarDatos()){
            Intent i = getIntent();
            i.putExtra(getString(R.string.REG_EMAIL),etRegUserEmail.getText().toString().trim());
            i.putExtra(getString(R.string.REG_PASWD),etRegUserPassword.getText().toString().trim());
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
        if (etRegUserEmail.getText().toString().trim().isEmpty() || etRegUserPassword.getText().toString().trim().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}