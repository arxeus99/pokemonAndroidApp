package com.valentelmadafaka.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.valentelmadafaka.pokemonapp.dataBase.DBInterface;
import com.valentelmadafaka.pokemonapp.model.Pokemon;

import java.util.List;

public class Pokemon_Info extends AppCompatActivity {

    DBInterface db;
    Cursor c;
    Long idPokemon;
    String nombre;
    String descripcion;
    String tipo1;
    String tipo2;
    String img;
    private List<Pokemon> pokemonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon__info);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        TextView idn = findViewById(R.id.IDPokemon);
        TextView nombreP = findViewById(R.id.NombrePokemon);
        ImageView pokemonI = findViewById(R.id.ImagenPokemon);
        TextView desc = findViewById(R.id.DescripcionPokemon);

        idPokemon = Long.parseLong(id);
        db = new DBInterface(this);
        db.obre();
        c = db.obtenirPokemon(idPokemon);
        idPokemon = c.getLong(0);
        nombre = c.getString(1);
        descripcion = c.getString(2);
        /*if(c.getString(3).equals(0)){
            //solo un tipo
            tipo1 = c.getString(4);
            tipo2 = null;
        }else{
            //dos tipos
            String t = c.getString(4);
            String[] parts = t.split(",");
            tipo1 = parts[0];
            tipo2 = parts[1];
        }*/
        img = c.getString(5);
        db.tanca();
        idn.setText(Long.toString(idPokemon));
        nombreP.setText(nombre);
        desc.setText(descripcion);
        Resources res = getResources();
        int resID = res.getIdentifier(img , "drawable", getPackageName());
        pokemonI.setImageResource(resID);

    }
}
