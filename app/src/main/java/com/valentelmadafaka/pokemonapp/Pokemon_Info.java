package com.valentelmadafaka.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
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
    ImageView pokedex;
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
        ImageView type1 = findViewById(R.id.Tipo1);
        ImageView type2 = findViewById(R.id.Tipo2);
        pokedex = findViewById(R.id.imageView3);

        idPokemon = Long.parseLong(id);
        db = new DBInterface(this);
        db.obre();
        c = db.obtenirPokemon(idPokemon);
        idPokemon = c.getLong(0);
        nombre = c.getString(1);
        descripcion = c.getString(2);
        String cant = c.getString(3);
        if(c.getString(3).equals("0")){
            //solo un tipo
            tipo1 = "t" + c.getString(4);
            tipo2 = null;
        }else{
            //dos tipos
            String t = c.getString(4);
            String[] parts = t.split(",");
            tipo1 = "t" + parts[0];
            tipo2 = "t" + parts[1];
        }
        img = c.getString(6);
        db.tanca();
        idn.setText(Long.toString(idPokemon));
        nombreP.setText(nombre);
        desc.setText(descripcion);
        Resources res = getResources();
        int resID = res.getIdentifier(img , "drawable", getPackageName());
        pokemonI.setImageResource(resID);
        if(cant.equals("0")) {
            int t1 = res.getIdentifier(tipo1 , "drawable", getPackageName());
            type1.setImageResource(t1);
        } else {
            int t1 = res.getIdentifier(tipo1 , "drawable", getPackageName());
            type1.setImageResource(t1);
            int t2 = res.getIdentifier(tipo2 , "drawable", getPackageName());
            type2.setImageResource(t2);
        }
        moveAnimation();

    }

    public void moveAnimation() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(pokedex, "translationX", 1300f);
        animation.setDuration(2000);
        animation.start();
    }
}
