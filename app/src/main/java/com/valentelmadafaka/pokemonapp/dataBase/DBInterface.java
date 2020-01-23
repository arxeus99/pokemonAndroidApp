package com.valentelmadafaka.pokemonapp.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.valentelmadafaka.pokemonapp.model.Tipo;
import com.valentelmadafaka.pokemonapp.model.TipoDual;


public class DBInterface  {

    public static final String CLAU_ID = "_id";
    public static final String CLAU_NOM = "nom";
    public static final String CLAU_DESCRIPCIO = "descripcion";
    public static final String CLAU_DUAL = "dual";
    public static final String CLAU_TIPO = "tipo(s)";
    public static final String TAG = "DBInterface";
    public static final String BD_NOM = "PokemonApp";
    public static final String BD_TAULA = "pokemons";
    public static final int VERSIO = 1;
    public static final String BD_CREATE ="create table " + BD_TAULA + "( "
            + CLAU_ID + " integer primary key autoincrement, " + CLAU_NOM +"text not null, " + CLAU_DESCRIPCIO + " text not null, "
            + CLAU_DUAL + " text not null, "+CLAU_TIPO+" text not null);";
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

    public long insereixContacte(String nom, String descripcion, TipoDual tipoDual, Tipo tipo) {
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
        return bd.insert(BD_TAULA ,null, initialValues);
    }
}
