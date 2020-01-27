package com.valentelmadafaka.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.valentelmadafaka.pokemonapp.dataBase.DBInterface;
import com.valentelmadafaka.pokemonapp.model.Pokemon;
import com.valentelmadafaka.pokemonapp.model.Tipo;
import com.valentelmadafaka.pokemonapp.model.TipoDual;

import java.util.ArrayList;

public class FichaActivity extends AppCompatActivity {

    DBInterface db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        db = new DBInterface(this);
        db.obre();

        if(db.existsTaulaEntrenador()){
            setContentView(R.layout.activity_ficha);
        }else{
            setContentView(R.layout.cuestionario_layout);
            ArrayList<Pokemon> pokemons = new ArrayList<>();
            ArrayList<Tipo> tipos = new ArrayList<>();
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
            ArrayList<String> nombresPokemon = new ArrayList<>();
            for(Pokemon p: pokemons){
                nombresPokemon.add(p.getNombre());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, nombresPokemon);
            AutoCompleteTextView pokemon1 = (AutoCompleteTextView)findViewById(R.id.pokemon1tv);
            AutoCompleteTextView pokemon2 = (AutoCompleteTextView)findViewById(R.id.pokemon2tv);
            AutoCompleteTextView pokemon3 = (AutoCompleteTextView)findViewById(R.id.pokemon3tv);
            AutoCompleteTextView pokemon4 = (AutoCompleteTextView)findViewById(R.id.pokemon4tv);
            AutoCompleteTextView pokemon5 = (AutoCompleteTextView)findViewById(R.id.pokemon5tv);
            AutoCompleteTextView pokemon6 = (AutoCompleteTextView)findViewById(R.id.pokemon6tv);
            pokemon1.setAdapter(adapter);
            pokemon2.setAdapter(adapter);
            pokemon3.setAdapter(adapter);
            pokemon4.setAdapter(adapter);
            pokemon5.setAdapter(adapter);
            pokemon6.setAdapter(adapter);

        }



    }


}
