package com.valentelmadafaka.pokemonapp.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.valentelmadafaka.pokemonapp.model.Tipo;
import com.valentelmadafaka.pokemonapp.model.TipoDual;


public class DBInterface  {

    public static final String CLAU_ID = "_id";
    public static final String CLAU_NOM = "nom";
    public static final String CLAU_DESCRIPCIO = "descripcion";
    public static final String CLAU_DUAL = "dual";
    public static final String CLAU_TIPO = "tipos";
    public static final String CLAU_IMG = "imagen";
    public static final String TAG = "DBInterface";
    public static final String BD_NOM = "PokemonApp";
    public static final String BD_TAULA_POKEMONS = "pokemons";
    public static final String BD_TAULA_TIPOS = "tipos";
    public static final int VERSIO = 1;
    public static final String BD_CREATE_POKEMON ="create table if not exists " + BD_TAULA_POKEMONS + "( "
            + CLAU_ID + " integer primary key autoincrement, " + CLAU_NOM +" text not null, " + CLAU_DESCRIPCIO + " text not null, "
            + CLAU_DUAL + " text not null, "+CLAU_TIPO+" text not null, "+CLAU_IMG+" text not null);";
    public static final String BD_CREATE_TIPOS ="create table if not exists " + BD_TAULA_TIPOS + "( "
            + CLAU_ID + " integer primary key autoincrement, " + CLAU_NOM +" text not null);";
    private final Context context;
    private AjudaDB ajuda;
    private SQLiteDatabase bd;


    public DBInterface(Context con) {
        this.context = con;
        ajuda = new AjudaDB(context);
    }

    public DBInterface obre() throws SQLException {
        bd = ajuda.getWritableDatabase();
        return this;
    }
    //Tanca la Base de dades
    public void tanca() {
        ajuda.close();
    }


    public SQLiteDatabase getBd(){
        return this.bd;
    }

    public long insereixPokemon (String nom, String descripcion, TipoDual tipoDual, Tipo tipo, String imagen) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(CLAU_NOM, nom);
        initialValues.put(CLAU_DESCRIPCIO, descripcion);
        if(tipoDual == null){
            initialValues.put(CLAU_DUAL, "0");
            initialValues.put(CLAU_TIPO, tipo.getId()+"");
        }else{
            initialValues.put(CLAU_DUAL, "1");
            initialValues.put(CLAU_TIPO, tipoDual.getTipo1().getId()+","+tipoDual.getTipo2().getId());
        }
        initialValues.put(CLAU_IMG, imagen);
        return bd.insert(BD_TAULA_POKEMONS,null, initialValues);
    }

    public long insereixTipus(String nom){
        ContentValues initialValues = new ContentValues();
        initialValues.put(CLAU_NOM, nom);
        return bd.insert(BD_TAULA_TIPOS,null, initialValues);
    }

    public Cursor obtenirPokemon(long IDFila) throws SQLException {
        Cursor mCursor = bd.query(true, BD_TAULA_POKEMONS, new String[] {CLAU_ID,
                        CLAU_NOM,CLAU_DESCRIPCIO,CLAU_DUAL,CLAU_TIPO},CLAU_ID + " = " + IDFila, null, null, null, null,
                null);
        if(mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor obtenirTipus(long IDFila) throws SQLException {
        Cursor mCursor = bd.query(true, BD_TAULA_TIPOS, new String[] {CLAU_ID,
                        CLAU_NOM,CLAU_DESCRIPCIO,CLAU_DUAL,CLAU_TIPO},CLAU_ID + " = " + IDFila, null, null, null, null,
                null);
        if(mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor obtenirTotsElsPokemon() {
        return bd.query(BD_TAULA_POKEMONS, new String[] {CLAU_ID, CLAU_NOM, CLAU_DESCRIPCIO,CLAU_DUAL,CLAU_TIPO, CLAU_IMG},
                null,null, null, null, null);
    }

    public Cursor obtenirTotsElsTipus() {
        return bd.query(BD_TAULA_TIPOS, new String[] {CLAU_ID, CLAU_NOM},
                null,null, null, null, null);
    }
}
