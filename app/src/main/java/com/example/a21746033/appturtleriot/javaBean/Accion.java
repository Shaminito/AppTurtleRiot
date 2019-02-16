package com.example.a21746033.appturtleriot.javaBean;

import android.graphics.drawable.Drawable;

public class Accion {

    //NOMBRE
    private String propietario;
    //TITULO
    private String titulo;
    //FOTO
    //private Drawable foto =
    //PLAYA
    //private Playa playa;
    //FECHA
    private String fecha;
    //DESCRIPCIÓN
    private String descripcion;

    public Accion(String propietario, String titulo, String fecha, String descripcion){
        this.propietario = propietario;
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
