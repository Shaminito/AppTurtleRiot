package com.example.a21746033.appturtleriot.fbDataBase;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.a21746033.appturtleriot.javaBean.Playas;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireDataBase {

    private DatabaseReference dbR;
    private ChildEventListener cel;

    public FireDataBase() {
        this.dbR = FirebaseDatabase.getInstance().getReference().child("acciones");
        addChildEventListener();
    }

    private void addChildEventListener() {
        if (cel == null) {
            cel = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    /*
                    System.out.println("Nuevo mensaje");
                    Mensaje m = dataSnapshot.getValue(Mensaje.class);
                    datos.add(m);
                    adapter.notifyItemInserted(datos.size()-1);
                     */
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    /*
                    System.out.println("Mensaje modificado");
                    Mensaje m = dataSnapshot.getValue(Mensaje.class);

                    int pos = 0;
                    for (int i = 0; i < datos.size(); i++) {
                        if (datos.get(i).getTextoMsj().equals(m.getTextoMsj())) {
                            datos.set(i, m);
                            pos = i;
                        }
                    }
                    adapter.notifyItemChanged(pos);
                     */
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    /*
                    //System.out.println("Mensaje borrado: "
                    //+ dataSnapshot.getValue(Mensaje.class).getTextoMsj());
                    adapter.notifyDataSetChanged();
                     */

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

    public void crearAccion(String userNam, Playas playa){
        userNam = userNam.replace(".","");
        dbR.child(userNam).setValue(playa);
    }
}
