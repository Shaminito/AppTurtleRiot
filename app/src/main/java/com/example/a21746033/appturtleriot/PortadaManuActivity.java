package com.example.a21746033.appturtleriot;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class PortadaManuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private LinearLayout llAcciones;
    private LinearLayout llAdvertencia;
    private LinearLayout llPlayas;
    private LinearLayout llIr;

    private RelativeLayout rlFragmentContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada_manu);

        llAcciones = findViewById(R.id.llAcciones);
        llAdvertencia = findViewById(R.id.llAdvertencia);
        llPlayas = findViewById(R.id.llPlayas);
        llIr = findViewById(R.id.llIr);

        rlFragmentContent = findViewById(R.id.rlFragmentContent);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Controladores para la barra de menú
        c_llAcciones();
        c_llAdvertencia();
        c_llPlayas();
        c_llIr();
    }

    private void c_llAcciones() {
        llAcciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlFragmentContent.removeAllViews();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.rlFragmentContent, new AccionesFragment());
                ft.commit();
            }
        });
    }

    private void c_llAdvertencia() {
        llAdvertencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlFragmentContent.removeAllViews();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.rlFragmentContent, new AdvertenciaFragment());
                ft.commit();
            }
        });
    }

    private void c_llPlayas() {
        llPlayas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO PlayasFragment
            }
        });
    }

    private void c_llIr() {
        llIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO IrFragment
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.portada_manu, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
