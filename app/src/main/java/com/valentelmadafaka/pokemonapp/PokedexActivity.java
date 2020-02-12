package com.valentelmadafaka.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.animation.ObjectAnimator;
import android.content.res.Resources;

import com.valentelmadafaka.pokemonapp.dataBase.DBInterface;
import com.valentelmadafaka.pokemonapp.model.Pokemon;
import com.valentelmadafaka.pokemonapp.model.PokemonsArray;
import com.valentelmadafaka.pokemonapp.model.Tipo;
import com.valentelmadafaka.pokemonapp.model.TipoDual;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PokedexActivity extends AppCompatActivity {

    DBInterface db;
    ArrayList<Pokemon> pokemons = new ArrayList<>();
    ArrayList<Tipo> tipos = new ArrayList<>();
    EditText num;
    AutoCompleteTextView pokemon, tipo1, tipo2;
    PokemonsArray pokemonsArray;
    ImageView pokedex;
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
                Pokemon p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), tipo, c.getString(5), c.getString(6));
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
                Pokemon p = new Pokemon(c.getString(0), c.getString(1),c.getString(2), new TipoDual(tipo1, tipo2), c.getString(5), c.getString(6));
                pokemons.add(p);
            }
            c.moveToNext();
        }


        db.tanca();

        if (getResources().getBoolean(R.bool.modeHoritzontal)) {
            num = findViewById(R.id.editText);
            pokemon = findViewById(R.id.editText3);
            tipo1 = findViewById(R.id.autoCompleteTextView);
            tipo2 = findViewById(R.id.autoCompleteTextView2);
            ArrayList<String> nombresPokemon = new ArrayList<>();
            for(Pokemon p: pokemons){
                nombresPokemon.add(p.getNombre());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, nombresPokemon);
            pokemon.setAdapter(adapter);

            ArrayList<String> nombresTipos = new ArrayList<>();

            for(Tipo t: tipos){
                nombresTipos.add(t.getNombre());
            }

            ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, nombresTipos);

            tipo1.setAdapter(adapter2);
            tipo2.setAdapter(adapter2);
        }

        pokedex = findViewById(R.id.imageView3);
        pokemonsArray = new PokemonsArray(this, R.layout.pokemon_pokedex, pokemons);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(pokemonsArray);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String idPokemon = ((TextView) view.findViewById(R.id.Numero)).getText().toString();
                boolean
                        horitzontal=getResources().getBoolean(R.bool.modeHoritzontal);
                if(horitzontal) {
                    Intent info = new Intent(PokedexActivity.this, Pokemon_Info.class);
                    info.putExtra("id", idPokemon);
                    startActivity(info);
                } else {
                    ((InfoFragment) getSupportFragmentManager().findFragmentById(R.id.Frgdetall)).mostrarDetall(idPokemon);
                    moveAnimation();
                }
            }
        });
    }

    public void buscarVoid(View view) {
        db.obre();
        pokemons.clear();
        pokemonsArray.clear();
        Cursor c;
        if(num.getText().toString().isEmpty() & pokemon.getText().toString().isEmpty() & tipo1.getText().toString().isEmpty() & tipo2.getText().toString().isEmpty()){
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
                    Pokemon p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), tipo, c.getString(5), c.getString(6));
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
                    Pokemon p = new Pokemon(c.getString(0), c.getString(1),c.getString(2), new TipoDual(tipo1, tipo2), c.getString(5), c.getString(6));
                    pokemons.add(p);
                }
                c.moveToNext();
            }


            db.tanca();
        }else{

            if(!(num.getText().toString().isEmpty()) & pokemon.getText().toString().isEmpty() & tipo1.getText().toString().isEmpty() & tipo2.getText().toString().isEmpty() ){
                c = db.obtenirPokemon(Integer.parseInt(num.getText().toString()));
                c.moveToFirst();
                while(!c.isAfterLast()){
                    if(c.getString(3).equals("0")){
                        Tipo tipo = new Tipo();
                        for(Tipo t : tipos){
                            if(t.getId().equals(c.getString(4))){
                                tipo = t;
                            }
                        }
                        Pokemon p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), tipo, c.getString(5), c.getString(6));
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
                        Pokemon p = new Pokemon(c.getString(0), c.getString(1),c.getString(2), new TipoDual(tipo1, tipo2), c.getString(5), c.getString(6));
                        pokemons.add(p);
                    }
                    c.moveToNext();
                }
            }else if((num.getText().toString().isEmpty()) & pokemon.getText().toString().isEmpty() & !(tipo1.getText().toString().isEmpty()) & tipo2.getText().toString().isEmpty()){
                Tipo aux = new Tipo();
                for(Tipo t: tipos){
                    if(t.getNombre().equals(tipo1.getText().toString())){
                        aux = t;
                    }
                }
                c = db.obtenirPokemon(aux);
                c.moveToFirst();
                while(!c.isAfterLast()) {
                    if (c.getString(3).equals("0")) {
                        Tipo tipo = new Tipo();
                        for (Tipo t : tipos) {
                            if (t.getId().equals(c.getString(4))) {
                                tipo = t;
                            }
                        }
                        Pokemon p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), tipo, c.getString(5), c.getString(6));
                        pokemons.add(p);
                    } else {
                        Tipo tipo1 = new Tipo();
                        Tipo tipo2 = new Tipo();
                        String[] tipos2 = c.getString(4).split(",");
                        for (Tipo t : tipos) {
                            if (t.getId().equals(tipos2[0])) {
                                tipo1 = t;
                            } else if (t.getId().equals(tipos2[1])) {
                                tipo2 = t;
                            }
                        }
                        Pokemon p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), new TipoDual(tipo1, tipo2), c.getString(5), c.getString(6));
                        pokemons.add(p);
                    }
                    c.moveToNext();
                }
            }else if((num.getText().toString().isEmpty()) & pokemon.getText().toString().isEmpty() & !(tipo1.getText().toString().isEmpty()) & !(tipo2.getText().toString().isEmpty())){
                Tipo aux = new Tipo();
                Tipo aux2 = new Tipo();
                for(Tipo t: tipos){
                    if(t.getNombre().equals(tipo1.getText().toString())){
                        aux = t;
                    }else if(t.getNombre().equals(tipo2.getText().toString())){
                        aux2 = t;
                    }
                }
                c = db.obtenirPokemon(aux, aux2);
                c.moveToFirst();
                while(!c.isAfterLast()) {
                    if (c.getString(3).equals("0")) {
                        Tipo tipo = new Tipo();
                        for (Tipo t : tipos) {
                            if (t.getId().equals(c.getString(4))) {
                                tipo = t;
                            }
                        }
                        Pokemon p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), tipo, c.getString(5), c.getString(6));
                        pokemons.add(p);
                    } else {
                        Tipo tipo1 = new Tipo();
                        Tipo tipo2 = new Tipo();
                        String[] tipos2 = c.getString(4).split(",");
                        for (Tipo t : tipos) {
                            if (t.getId().equals(tipos2[0])) {
                                tipo1 = t;
                            } else if (t.getId().equals(tipos2[1])) {
                                tipo2 = t;
                            }
                        }
                        Pokemon p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), new TipoDual(tipo1, tipo2), c.getString(5), c.getString(6));
                        pokemons.add(p);
                    }
                    c.moveToNext();
                }
            }else if((num.getText().toString().isEmpty()) & !(pokemon.getText().toString().isEmpty()) & (tipo1.getText().toString().isEmpty()) & tipo2.getText().toString().isEmpty()){
                c = db.obtenirPokemon(pokemon.getText().toString());
                c.moveToFirst();
                while(!c.isAfterLast()) {
                    if (c.getString(3).equals("0")) {
                        Tipo tipo = new Tipo();
                        for (Tipo t : tipos) {
                            if (t.getId().equals(c.getString(4))) {
                                tipo = t;
                            }
                        }
                        Pokemon p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), tipo, c.getString(5), c.getString(6));
                        pokemons.add(p);
                    } else {
                        Tipo tipo1 = new Tipo();
                        Tipo tipo2 = new Tipo();
                        String[] tipos2 = c.getString(4).split(",");
                        for (Tipo t : tipos) {
                            if (t.getId().equals(tipos2[0])) {
                                tipo1 = t;
                            } else if (t.getId().equals(tipos2[1])) {
                                tipo2 = t;
                            }
                        }
                        Pokemon p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), new TipoDual(tipo1, tipo2), c.getString(5), c.getString(6));
                        pokemons.add(p);
                    }
                    c.moveToNext();
                }
            }else if((num.getText().toString().isEmpty()) & !(pokemon.getText().toString().isEmpty()) & !(tipo1.getText().toString().isEmpty()) & tipo2.getText().toString().isEmpty()){
                Tipo aux = new Tipo();
                for(Tipo t: tipos){
                    if(t.getNombre().equals(tipo1.getText().toString())){
                        aux = t;
                    }
                }
                c = db.obtenirPokemon(pokemon.getText().toString(), aux);
                c.moveToFirst();
                while(!c.isAfterLast()) {
                    if (c.getString(3).equals("0")) {
                        Tipo tipo = new Tipo();
                        for (Tipo t : tipos) {
                            if (t.getId().equals(c.getString(4))) {
                                tipo = t;
                            }
                        }
                        Pokemon p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), tipo, c.getString(5), c.getString(6));
                        pokemons.add(p);
                    } else {
                        Tipo tipo1 = new Tipo();
                        Tipo tipo2 = new Tipo();
                        String[] tipos2 = c.getString(4).split(",");
                        for (Tipo t : tipos) {
                            if (t.getId().equals(tipos2[0])) {
                                tipo1 = t;
                            } else if (t.getId().equals(tipos2[1])) {
                                tipo2 = t;
                            }
                        }
                        Pokemon p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), new TipoDual(tipo1, tipo2), c.getString(5), c.getString(6));
                        pokemons.add(p);
                    }
                    c.moveToNext();
                }
            }else if((num.getText().toString().isEmpty()) & !(pokemon.getText().toString().isEmpty()) & !(tipo1.getText().toString().isEmpty()) & !(tipo2.getText().toString().isEmpty())){
                Tipo aux = new Tipo();
                Tipo aux2 = new Tipo();
                for(Tipo t: tipos){
                    if(t.getNombre().equals(tipo1.getText().toString())){
                        aux = t;
                    }else if(t.getNombre().equals(tipo2.getText().toString())){
                        aux2 = t;
                    }
                }
                c = db.obtenirPokemon(pokemon.getText().toString(),aux, aux2);
                c.moveToFirst();
                while(!c.isAfterLast()) {
                    if (c.getString(3).equals("0")) {
                        Tipo tipo = new Tipo();
                        for (Tipo t : tipos) {
                            if (t.getId().equals(c.getString(4))) {
                                tipo = t;
                            }
                        }
                        Pokemon p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), tipo, c.getString(5), c.getString(6));
                        pokemons.add(p);
                    } else {
                        Tipo tipo1 = new Tipo();
                        Tipo tipo2 = new Tipo();
                        String[] tipos2 = c.getString(4).split(",");
                        for (Tipo t : tipos) {
                            if (t.getId().equals(tipos2[0])) {
                                tipo1 = t;
                            } else if (t.getId().equals(tipos2[1])) {
                                tipo2 = t;
                            }
                        }
                        Pokemon p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), new TipoDual(tipo1, tipo2), c.getString(5), c.getString(6));
                        pokemons.add(p);
                    }
                    c.moveToNext();
                }
            }
        }
        db.tanca();
    }

    public void moveAnimation() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(pokedex, "translationX", 1300f);
        animation.setDuration(1500);
        animation.start();
    }

}
