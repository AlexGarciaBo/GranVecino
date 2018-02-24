package com.example.alberto.granvecino;

/**
 * Created by alberto on 14/02/2018.
 */

public class Persona {

    String nombre;
    String apellidos;
    String edad;
    int trabajosCompletados;




    public Persona(String nombre, String apellidos, String edad, int trabajosCompletados) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.trabajosCompletados = trabajosCompletados;

    }

    public Persona(String pepe, String perez, String s) {

    }

    public int getTrabajosCompletados() {
        return trabajosCompletados;
    }

    public void setTrabajosCompletados(int trabajosCompletados) {
        this.trabajosCompletados = trabajosCompletados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
