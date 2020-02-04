package com.valentelmadafaka.pokemonapp.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.valentelmadafaka.pokemonapp.model.Tipo;
import com.valentelmadafaka.pokemonapp.model.TipoDual;


public class DBInterface  {

    public static final String CLAU_ID = "_id";
    public static final String CLAU_NOM = "nom";
    public static final String CLAU_DESCRIPCIO = "descripcion";
    public static final String CLAU_IMGG = "imagen_grande";
    public static final String CLAU_DUAL = "dual";
    public static final String CLAU_TIPO = "tipos";
    public static final String CLAU_IMG = "imagen";
    public static final String CLAU_EQUIPO = "equipo_pokemon";
    public static final String TAG = "DBInterface";
    public static final String BD_NOM = "PokemonApp";
    public static final String BD_TAULA_POKEMONS = "pokemons";
    public static final String BD_TAULA_TIPOS = "tipos";
    public static final String BD_TAULA_ENTRENADOR = "entrenador";
    public static final int VERSIO = 1;
    public static final String BD_CREATE_POKEMON ="create table if not exists " + BD_TAULA_POKEMONS + "( "
            + CLAU_ID + " integer primary key autoincrement, " + CLAU_NOM +" text not null, " + CLAU_DESCRIPCIO + " text not null, "
            + CLAU_DUAL + " text not null, "+CLAU_TIPO+" text not null, "+CLAU_IMG+" text not null, "+CLAU_IMGG+" text not null);";
    public static final String BD_CREATE_TIPOS ="create table if not exists " + BD_TAULA_TIPOS + "( "
            + CLAU_ID + " integer primary key autoincrement, " + CLAU_NOM +" text not null, "+CLAU_IMG+" text not null);";
    public static final String BD_CREATE_ENTRENADOR = "create table if not exists "+BD_TAULA_ENTRENADOR+"( "+CLAU_ID+" integer primary key autoincrement, "+CLAU_NOM+" text not null, "+CLAU_IMG+" text not null, "+
                CLAU_EQUIPO+" text not null);";
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

    public long insereixPokemon (String nom, String descripcion, TipoDual tipoDual, Tipo tipo, String imagen, String imagenG) {
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
        initialValues.put(CLAU_IMGG, imagenG);
        return bd.insert(BD_TAULA_POKEMONS,null, initialValues);
    }

    public long insereixTipus(String nom, String img){
        ContentValues initialValues = new ContentValues();
        initialValues.put(CLAU_NOM, nom);
        initialValues.put(CLAU_IMG, img);
        return bd.insert(BD_TAULA_TIPOS,null, initialValues);
    }

    public long insereixEntrenador(String nom, String img, String pokemons){
        ContentValues initialValues = new ContentValues();
        initialValues.put(CLAU_NOM, nom);
        initialValues.put(CLAU_IMG, img);
        initialValues.put(CLAU_EQUIPO, pokemons);
        return bd.insert(BD_TAULA_ENTRENADOR, null, initialValues);
    }

    public boolean esborraEntrenador(String IDFila) {
        return bd.delete(BD_TAULA_ENTRENADOR, CLAU_ID+" = "+ IDFila, null) > 0;
    }

    public Cursor obtenirPokemon(long IDFila) throws SQLException {
        Cursor mCursor = bd.query(true, BD_TAULA_POKEMONS, new String[] {CLAU_ID,
                        CLAU_NOM,CLAU_DESCRIPCIO,CLAU_DUAL,CLAU_TIPO, CLAU_IMG, CLAU_IMGG},CLAU_ID + " = " + IDFila, null, null, null, null,
                null);
        if(mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public Cursor obtenirPokemon(String nom) throws SQLException{
        Cursor mCursor = bd.query(true, BD_TAULA_POKEMONS, new String[]{CLAU_ID,
        CLAU_NOM, CLAU_DESCRIPCIO, CLAU_DUAL,  CLAU_TIPO, CLAU_IMG, CLAU_IMGG}, CLAU_NOM+" LIKE '"+nom+"%'", null,null,null,null,
        null);
        if(mCursor != null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public Cursor obtenirPokemon(String nom, Tipo tipo) throws SQLException{
        Cursor mCursor = bd.query(true, BD_TAULA_POKEMONS, new String[]{CLAU_ID,
                        CLAU_NOM, CLAU_DESCRIPCIO, CLAU_DUAL,  CLAU_TIPO, CLAU_IMG, CLAU_IMGG}, CLAU_NOM+" LIKE '"+nom+"%' AND ("+CLAU_TIPO+" = "+tipo.getId()+" or "+CLAU_TIPO+" LIKE '"+tipo.getId()+",%'"+ " or "+CLAU_TIPO+" LIKE '%,"+tipo.getId()+"')", null,null,null,null,
                null);
        if(mCursor != null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public Cursor obtenirPokemon(String nom, Tipo tipo1, Tipo tipo2) throws SQLException{
        Cursor mCursor = bd.query(true, BD_TAULA_POKEMONS, new String[]{CLAU_ID,
                        CLAU_NOM, CLAU_DESCRIPCIO, CLAU_DUAL,  CLAU_TIPO, CLAU_IMG, CLAU_IMGG}, CLAU_NOM+" LIKE '"+nom+"%' AND ("+CLAU_TIPO+" = '"+tipo1.getId()+","+tipo2.getId()+"' OR "+CLAU_TIPO+" = '"+tipo2.getId()+","+tipo1.getId()+"')", null,null,null,null,
                null);
        if(mCursor != null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public Cursor obtenirPokemon(Tipo tipo) throws SQLException{
        Cursor mCursor = bd.query(true, BD_TAULA_POKEMONS, new String[]{CLAU_ID,
        CLAU_NOM, CLAU_DESCRIPCIO, CLAU_DUAL,  CLAU_TIPO, CLAU_IMG, CLAU_IMGG}, CLAU_TIPO+" = "+tipo.getId()+" or "+CLAU_TIPO+" LIKE '"+tipo.getId()+",%'"+ " or "+CLAU_TIPO+" LIKE '%,"+tipo.getId()+"'", null,null,null,null,
        null);
        if(mCursor != null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public Cursor obtenirPokemon(Tipo tipo, Tipo tipo2) throws SQLException{
        Cursor mCursor = bd.query(true, BD_TAULA_POKEMONS, new String[]{CLAU_ID,
        CLAU_NOM, CLAU_DESCRIPCIO, CLAU_DUAL,  CLAU_TIPO, CLAU_IMG, CLAU_IMGG}, CLAU_TIPO+" = '"+tipo.getId()+","+tipo2.getId()+"' OR "+CLAU_TIPO+" = '"+tipo2.getId()+","+tipo.getId()+"'", null,null,null,null,
        null);
        if(mCursor != null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor obtenirTipus(long IDFila) throws SQLException {
        Cursor mCursor = bd.query(true, BD_TAULA_TIPOS, new String[] {CLAU_ID, CLAU_NOM, CLAU_IMG},CLAU_ID + " = " + IDFila, null, null, null, null,
                null);
        if(mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor obtenirEntrendaor(){
        return bd.query(BD_TAULA_ENTRENADOR, new String[] {CLAU_ID, CLAU_NOM, CLAU_IMG, CLAU_EQUIPO}, null, null, null, null, null);
    }

    public boolean isEntrenadorEmpty() {
        Cursor cursor = bd.rawQuery("SELECT count(*) FROM " + BD_TAULA_ENTRENADOR, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        return count < 1;
    }

    public boolean isPokemonEmpty(){
        Cursor cursor = bd.rawQuery("SELECT count(*) FROM "+BD_TAULA_POKEMONS, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
            return count<1;
    }

    public boolean isTiposEmpty(){
        Cursor cursor = bd.rawQuery("SELECT count(*) FROM "+BD_TAULA_TIPOS, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
            return count<1;
    }

    public Cursor obtenirTotsElsPokemon() {
        return bd.query(BD_TAULA_POKEMONS, new String[] {CLAU_ID, CLAU_NOM, CLAU_DESCRIPCIO,CLAU_DUAL,CLAU_TIPO, CLAU_IMG, CLAU_IMGG},
                null,null, null, null, null);
    }

    public Cursor obtenirTotsElsTipus() {
        return bd.query(BD_TAULA_TIPOS, new String[] {CLAU_ID, CLAU_NOM, CLAU_IMG},
                null,null, null, null, null);
    }

    public boolean actualitzarEntrenador(String IDFila, String nom, String equipo, String img) {
        ContentValues args = new ContentValues();
        args.put(CLAU_NOM, nom);
        args.put(CLAU_EQUIPO, equipo);
        args.put(CLAU_IMG, img);
        return bd.update(BD_TAULA_ENTRENADOR, args, CLAU_ID + " = " + IDFila, null) > 0;
    }
}
