package com.turtleriot.javaBean;

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

    public Accion(){}

    public Accion(String propietario, String titulo, String fecha, String descripcion){
        this.propietario = propietario;
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    // Métodos utilizados para el firebase

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
