package com.turtleriot.acciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.turtleriot.R;

public class AccionesSeguidosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acciones_seguidos);

        getSupportActionBar().hide();
    }
}
