package com.valentelmadafaka.pokemonapp.model;

import java.util.Arrays;
import java.util.Objects;

public class Tipo {

    private String id;
    private String nombre;
    private byte[] icon;

    public Tipo(){ }

    public Tipo(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", icon=" + Arrays.toString(icon) +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public Tipo(String id, String nombre, byte[] icon) {
        this.id = id;
        this.nombre = nombre;
        this.icon = icon;
    }
}
