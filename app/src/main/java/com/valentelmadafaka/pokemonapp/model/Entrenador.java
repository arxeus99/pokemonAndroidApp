package com.valentelmadafaka.pokemonapp.model;

public class Entrenador {
    private String nombre;
    private String imagen;
    private Pokemon[] equipo;
    private String id;

    public Entrenador(String nombre, String imagen, Pokemon[] equipo) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.equipo = equipo;
    }

    public Entrenador(){

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Pokemon[] getEquipo() {
        return equipo;
    }

    public void setEquipo(Pokemon[] equipo) {
        this.equipo = equipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
