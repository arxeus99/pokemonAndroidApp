package com.valentelmadafaka.pokemonapp.model;

public class TipoDual {

    private Tipo tipo1;
    private Tipo tipo2;

    public TipoDual(Tipo tipo1, Tipo tipo2) {
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }

    public Tipo getTipo1() {
        return tipo1;
    }

    public void setTipo1(Tipo tipo1) {
        this.tipo1 = tipo1;
    }

    public Tipo getTipo2() {
        return tipo2;
    }

    public void setTipo2(Tipo tipo2) {
        this.tipo2 = tipo2;
    }
}
