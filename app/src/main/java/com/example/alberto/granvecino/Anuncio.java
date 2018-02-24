package com.example.alberto.granvecino;

/**
 * Created by alberto on 16/02/2018.
 */

public class Anuncio {

    private String trabajo;
    private String descripcion;
    private String anunciante;
    private String tipo;


    public Anuncio(String trabajo, String descripcion, String anunciante, String tipo) {
        this.trabajo = trabajo;
        this.descripcion = descripcion;
        this.anunciante = anunciante;
        this.tipo = tipo;
    }


    public String getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(String anunciante) {
        this.anunciante = anunciante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
