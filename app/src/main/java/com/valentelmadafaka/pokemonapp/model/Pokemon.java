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
        this.tipoDual = null;
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
        this.tipo = null;
        this.img = img;
    }

    public Pokemon(int id, String nombre, String descripcion, TipoDual tipoDual) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoDual = tipoDual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public TipoDual getTipoDual() {
        return tipoDual;
    }

    public void setTipoDual(TipoDual tipoDual) {
        this.tipoDual = tipoDual;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
