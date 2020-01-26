package com.valentelmadafaka.pokemonapp.model;

public class Pokemon {

    private String id;
    private String nombre;
    private String descripcion;
    private Tipo tipo;
    private TipoDual tipoDual;
    private String img;

    public Pokemon(String id, String nombre, String descripcion, Tipo tipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoDual = null;
        this.tipo = tipo;
    }

    public Pokemon(String id, String nombre, String descripcion, Tipo tipo, String img) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.img = img;
    }

    public Pokemon(String id, String nombre, String descripcion, TipoDual tipoDual, String img) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoDual = tipoDual;
        this.tipo = null;
        this.img = img;
    }

    public Pokemon(String id, String nombre, String descripcion, TipoDual tipoDual) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoDual = tipoDual;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
