package com.example.a21746033.appturtleriot.fbDataBase;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.a21746033.appturtleriot.javaBean.Accion;
import com.example.a21746033.appturtleriot.javaBean.BuscarAccionesAdaptador;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FireDataBase {

    private DatabaseReference dbR;
    private ChildEventListener cel;

    ArrayList<Accion> listaAcciones;
    BuscarAccionesAdaptador adaptador;

    public FireDataBase(){
        dbR = FirebaseDatabase.getInstance().getReference().child("acciones");
    }

    public void arrancarChildItemListener(){
        addChildItemListener();
    }

    public void guardarAccion(Accion accion) {
        dbR.child(dbR.push().getKey()).setValue(accion);
    }

    private void addChildItemListener() {
        if(cel == null){
            cel = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    Accion accion = dataSnapshot.getValue(Accion.class);
                    //if(accion.getPropietario() != ){
                        listaAcciones.add(accion);
                    //}
                    adaptador.notifyItemInserted(listaAcciones.size() - 1);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    //TODO CHANGED
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    //TODO REMOVED
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

    public void setListaAcciones(ArrayList<Accion> listaAcciones) {
        this.listaAcciones = listaAcciones;
    }

    public void setAdaptador(BuscarAccionesAdaptador adaptador) {
        this.adaptador = adaptador;
    }
}
