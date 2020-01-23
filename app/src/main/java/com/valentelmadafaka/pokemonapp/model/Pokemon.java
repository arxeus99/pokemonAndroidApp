package com.valentelmadafaka.pokemonapp.model;

import java.util.Arrays;
import java.util.Objects;

public class Pokemon {

    private int id;
    private String nombre;
    private String descripcion;
    private Tipo tipo;
    private TipoDual tipoDual;
    private byte[] img;

    public Pokemon(int id, String nombre, String descripcion, Tipo tipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Pokemon(int id, String nombre, String descripcion, Tipo tipo, byte[] img) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.img = img;
    }

    public Pokemon(int id, String nombre, String descripcion, TipoDual tipoDual, byte[] img) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoDual = tipoDual;
        this.img = img;
    }

    public Pokemon(int id, String nombre, String descripcion, TipoDual tipoDual) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoDual = tipoDual;
    }
}
