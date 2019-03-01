package com.turtleriot;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

public class PortadaManuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private LinearLayout llAcciones;
    private LinearLayout llAdvertencia;
    private LinearLayout llPlayas;
    private LinearLayout llIr;

    private TextView tvMenuNombre;

    private TextView tvAcciones;
    private TextView tvAdvertencia;
    private TextView tvPlayas;
    private TextView tvIr;

    private RelativeLayout rlFragmentContent;

    private String nombre;

    //private FireDataBase fdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada_manu);

        nombre = ((UsuarioApplication) getApplicationContext()).getUsuario().getUser();
        String clave = ((UsuarioApplication) getApplicationContext()).getClave();
        Toast.makeText(this,clave,Toast.LENGTH_LONG).show();

        llAcciones = findViewById(R.id.llAcciones);
        llAdvertencia = findViewById(R.id.llAdvertencia);
        llPlayas = findViewById(R.id.llPlayas);
        llIr = findViewById(R.id.llIr);

        tvMenuNombre = findViewById(R.id.tvMenuNombre);
        tvMenuNombre.setText(nombre);

        tvAcciones = findViewById(R.id.tvAcciones);
        tvAdvertencia = findViewById(R.id.tvAdvertencia);
        tvPlayas = findViewById(R.id.tvPlayas);
        tvIr = findViewById(R.id.tvIr);

        rlFragmentContent = findViewById(R.id.rlFragmentContent);

        //fdb = new FireDataBase();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
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

                AccionesFragment accionesFragment = new AccionesFragment();
                //accionesFragment.setFdb(fdb);

                ft.replace(R.id.rlFragmentContent, accionesFragment);
                ft.commit();
                contenidoSeleccionado(R.color.textColor_selected, R.color.textColor_Whiite, R.color.textColor_Whiite, R.color.textColor_Whiite);
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
                contenidoSeleccionado(R.color.textColor_Whiite, R.color.textColor_selected, R.color.textColor_Whiite, R.color.textColor_Whiite);
            }
        });
    }

    private void c_llPlayas() {
        llPlayas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO PlayasFragment
                contenidoSeleccionado(R.color.textColor_Whiite, R.color.textColor_Whiite, R.color.textColor_selected, R.color.textColor_Whiite);
            }
        });
    }

    private void c_llIr() {
        llIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO IrFragment
                contenidoSeleccionado(R.color.textColor_Whiite, R.color.textColor_Whiite, R.color.textColor_Whiite, R.color.textColor_selected);
            }
        });
    }

    private void contenidoSeleccionado(int colorAcciones, int colorAdvertencia, int colorPlayas, int colorIr) {
        tvAcciones.setTextColor(getResources().getColor(colorAcciones));
        tvAdvertencia.setTextColor(getResources().getColor(colorAdvertencia));
        tvPlayas.setTextColor(getResources().getColor(colorPlayas));
        tvIr.setTextColor(getResources().getColor(colorIr));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        if(item.getItemId() == R.id.nav_fotos){
            Toast.makeText(getApplicationContext(),"Fotos",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId() == R.id.nav_config){
            Intent i = new Intent(PortadaManuActivity.this,ConfigUserActivity.class);
            startActivity(i);
        }
        else if(item.getItemId() == R.id.nav_compa){
            Toast.makeText(getApplicationContext(),"Compartir",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId() == R.id.nav_send){
            Toast.makeText(getApplicationContext(),"Enviar",Toast.LENGTH_LONG).show();
        }

        return true;
    }
}