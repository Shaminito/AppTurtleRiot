package com.turtleriot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ConfigUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_user);

        getSupportActionBar().hide();
    }
}
