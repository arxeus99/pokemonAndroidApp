package com.valentelmadafaka.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.valentelmadafaka.pokemonapp.dataBase.DBInterface;
import com.valentelmadafaka.pokemonapp.model.Pokemon;
import com.valentelmadafaka.pokemonapp.model.Tipo;
import com.valentelmadafaka.pokemonapp.model.TipoDual;

public class AnyadirActivity extends AppCompatActivity {

    DBInterface db;
    Tipo planta = new Tipo(10, "planta");
    Tipo veneno = new Tipo(14, "veneno");
    Pokemon bulbasur = new Pokemon(1, "Bulbasur", "Puede sobrevivir largo tiempo sin probar bocado. Guarda energia en el bublo de su espalda.",new TipoDual(planta,veneno));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyadir);
    }

    public void añadirVoid(View view) {
        db = new DBInterface(this);
        db.obre();
        if (db.insereixContacte(bulbasur.getNombre(), bulbasur.getDescripcion(), bulbasur.getTipoDual(), bulbasur.getTipo()) != -1) {
            Toast.makeText(this, "Afegit correctament",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error a l’afegir",
                    Toast.LENGTH_SHORT).show();
        }
        db.tanca();
        finish();
    }
}
