package com.example.alberto.granvecino;

/**
 * Created by alberto on 16/02/2018.
 */

public class Anuncio extends Persona{


    String trabajo;
    String descripcion;

    public Anuncio(String nombre, String apellidos, String edad, String trabajo, String descripcion) {
        super(nombre, apellidos, edad);

        this.trabajo = trabajo;
        this.descripcion = descripcion;
    }


    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
