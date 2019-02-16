package com.example.a21746033.appturtleriot.fbDataBase;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.a21746033.appturtleriot.javaBean.Accion;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireDataBase {

    private DatabaseReference dbR;
    private ChildEventListener cel;


    public FireDataBase(){
        dbR = FirebaseDatabase.getInstance().getReference().child("acciones");
        //addChildItemListener();
    }

    public void guardarAccion(Accion accion) {
        dbR.child(accion.getPropietario()).setValue(accion);
    }

    /*
    private void addChildItemListener() {
        if(cel == null){
            cel = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    Viaje v = dataSnapshot.getValue(Viaje.class);
                    listaViajes.add(v);
                    adaptador.notifyItemInserted(listaViajes.size()-1);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    Viaje v = dataSnapshot.getValue(Viaje.class);
                    int pos = 0;
                    for(int i = 0 ; i < listaViajes.size() ; i++){
                        if(listaViajes.get(i).getNombreViaje().equals(v.getNombreViaje())){
                            listaViajes.set(i,v);
                            pos = i;
                        }
                    }
                    adaptador.notifyItemChanged(pos);
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    adaptador.notifyDataSetChanged();
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
     */
}
