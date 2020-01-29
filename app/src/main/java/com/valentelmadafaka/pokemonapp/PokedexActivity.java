package com.valentelmadafaka.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.valentelmadafaka.pokemonapp.dataBase.DBInterface;
import com.valentelmadafaka.pokemonapp.model.Pokemon;
import com.valentelmadafaka.pokemonapp.model.PokemonsArray;
import com.valentelmadafaka.pokemonapp.model.Tipo;
import com.valentelmadafaka.pokemonapp.model.TipoDual;

import java.util.ArrayList;

public class PokedexActivity extends AppCompatActivity {

    DBInterface db;
    ArrayList<Pokemon> pokemons = new ArrayList<>();
    ArrayList<Tipo> tipos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
        db = new DBInterface(this);
        db.obre();

//


        Cursor c = db.obtenirTotsElsTipus();
        c.moveToFirst();
        while(!c.isAfterLast()){
            Tipo tipo = new Tipo(c.getString(0), c.getString(1),c.getString(2));
            tipos.add(tipo);
            c.moveToNext();
        }

        c = db.obtenirTotsElsPokemon();
        c.moveToFirst();
        while(!c.isAfterLast()){
            if(c.getString(3).equals("0")){
                Tipo tipo = new Tipo();
                for(Tipo t : tipos){
                    if(t.getId().equals(c.getString(4))){
                        tipo = t;
                    }
                }
                Pokemon p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), tipo, c.getString(5));
                pokemons.add(p);
            }else{
                Tipo tipo1 = new Tipo();
                Tipo tipo2 = new Tipo();
                String[] tipos2 = c.getString(4).split(",");
                for(Tipo t : tipos){
                    if(t.getId().equals(tipos2[0])){
                        tipo1 = t;
                    }else if(t.getId().equals(tipos2[1])){
                        tipo2 = t;
                    }
                }
                Pokemon p = new Pokemon(c.getString(0), c.getString(1),c.getString(2), new TipoDual(tipo1, tipo2), c.getString(5));
                pokemons.add(p);
            }
            c.moveToNext();
        }


        db.tanca();




        PokemonsArray pokemonsArray = new PokemonsArray(this, R.layout.pokemon_pokedex, pokemons);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(pokemonsArray);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String idPokemon = ((TextView) view.findViewById(R.id.Numero)).getText().toString();
                Intent info = new Intent(PokedexActivity.this, Pokemon_Info.class);
                info.putExtra("id", idPokemon);
                startActivity(info);
            }
        });
    }
}
