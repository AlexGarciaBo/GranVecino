package com.example.alberto.granvecino;



public class Oferta {
    private String trabajo;
    private String descripcion;
    private String user;
    private String tipo;

    public Oferta(String trabajo, String descripcion, String user, String tipo) {
        this.trabajo = trabajo;
        this.descripcion = descripcion;
        this.user = user;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}