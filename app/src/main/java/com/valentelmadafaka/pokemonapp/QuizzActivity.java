package com.valentelmadafaka.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.valentelmadafaka.pokemonapp.dataBase.DBInterface;
import com.valentelmadafaka.pokemonapp.model.Pokemon;
import com.valentelmadafaka.pokemonapp.model.Tipo;
import com.valentelmadafaka.pokemonapp.model.TipoDual;

import java.util.ArrayList;

public class QuizzActivity extends AppCompatActivity {

    DBInterface db;
    ArrayList<Tipo> tipos;
    Pokemon p;
    TextView respuesta;
    int tipoCorrecto;
    int puntuacion;
    int record;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        db = new DBInterface(this);
        tipos = new ArrayList<>();
        respuesta = (TextView)findViewById(R.id.respuesta);
        db.obre();
        Cursor c = db.obtenirTotsElsTipus();
        c.moveToFirst();
        while(!c.isAfterLast()){
            Tipo tipo = new Tipo(c.getString(0), c.getString(1),c.getString(2));
            tipos.add(tipo);
            c.moveToNext();
        }
        db.tanca();
        puntuacion = 0;
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("RECORD", Context.MODE_PRIVATE);
        record = prefs.getInt("record", 0);
        TextView recordTV = (TextView) findViewById(R.id.record);
        recordTV.setText("Record: "+record);
        loadGame();

    }

    void loadGame(){
        db.obre();
        int max = db.obtenirNombreDePokemon()+1;
        int id = (int)(Math.random() * (max - 1 + 1) + 1);

        Cursor c = db.obtenirPokemon(id);
        c.moveToFirst();
        while(!c.isAfterLast()){
            if(c.getString(3).equals("0")){
                Tipo tipo = new Tipo();
                for(Tipo t : tipos){
                    if(t.getId().equals(c.getString(4))){
                        tipo = t;
                    }
                }
                p = new Pokemon(c.getString(0), c.getString(1), c.getString(2), tipo, c.getString(5), c.getString(6));
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
                p = new Pokemon(c.getString(0), c.getString(1),c.getString(2), new TipoDual(tipo1, tipo2), c.getString(5), c.getString(6));
            }
            c.moveToNext();
        }
        ImageView pokemon = (ImageView)findViewById(R.id.selectedPokemon);
        int imageID = this.getResources().getIdentifier(p.getImgg(), "drawable", this.getPackageName());
        pokemon.setImageResource(imageID);

        ImageView tipo1 = (ImageView)findViewById(R.id.tipo1);
        ImageView tipo2 = (ImageView)findViewById(R.id.tipo2);
        ImageView tipo3 = (ImageView)findViewById(R.id.tipo3);
        ImageView tipo4 = (ImageView)findViewById(R.id.tipo4);

        ArrayList<String> tiposUsados = new ArrayList<>();
        if(p.getTipoDual() == null){
            tiposUsados.add(p.getTipo().getId());
        }else{
            tiposUsados.add(p.getTipoDual().getTipo1().getId());
            tiposUsados.add(p.getTipoDual().getTipo2().getId());
        }
        tipoCorrecto = (int)(Math.random() * (4 - 1 + 1) + 1);
        for(int i = 1; i<5; i++){
            int tipoID;
            if(i == tipoCorrecto){
                if(p.getTipoDual() == null){
                    tipoID = this.getResources().getIdentifier(p.getTipo().getIcon(), "drawable", this.getPackageName());
                }else{
                    tipoID = this.getResources().getIdentifier(p.getTipoDual().getTipo1().getIcon(), "drawable", this.getPackageName());
                }
            }else{
                int randomID = (int)(Math.random()*((tipos.size()-1) - 0 +1)-0);
                Tipo t = tipos.get(randomID);
                while(tiposUsados.contains(t.getId())){
                    randomID = (int)(Math.random()*(((tipos.size()-1)-0 + 1)-0));
                    t = tipos.get(randomID);
                }
                tiposUsados.add(t.getId());
                tipoID = this.getResources().getIdentifier(t.getIcon(), "drawable", this.getPackageName());
            }

            switch (i){
                case 1:{
                    tipo1.setImageResource(tipoID);
                    break;
                }
                case 2:{
                    tipo2.setImageResource(tipoID);
                    break;
                }
                case 3:{
                    tipo3.setImageResource(tipoID);
                    break;
                }
                case 4:{
                    tipo4.setImageResource(tipoID);
                    break;
                }
            }
        }
    }

    public void imageOneVoid(View view) {
        if(tipoCorrecto == 1){
            puntuacion++;
            respuesta.setText("Puntuacion: "+puntuacion);
            loadGame();
            Snackbar.make(view, "CORRECTO!", Snackbar.LENGTH_LONG).show();
        }else{
            if(puntuacion>record){
                SharedPreferences prefs =getApplicationContext().getSharedPreferences("RECORD", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =prefs.edit();
                editor.putInt("record", puntuacion);
                editor.commit();
                Toast toast1 = Toast.makeText(getApplicationContext(), "ES UN NUEVO RECORD!", Toast.LENGTH_SHORT);
                toast1.show();
            }else{
                Toast toast1 = Toast.makeText(getApplicationContext(), "RESPUESTA INCORRECTA!", Toast.LENGTH_SHORT);
                toast1.show();
            }

            finish();
        }
    }
    public void imageTwoVoid(View view) {
        if(tipoCorrecto == 2){
            puntuacion++;
            respuesta.setText("Puntuacion: "+puntuacion);
            loadGame();
            Snackbar.make(view, "CORRECTO!", Snackbar.LENGTH_LONG).show();
        }else{
            if(puntuacion>record){
                SharedPreferences prefs =getApplicationContext().getSharedPreferences("RECORD", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =prefs.edit();
                editor.putInt("record", puntuacion);
                editor.commit();
                Toast toast1 = Toast.makeText(getApplicationContext(), "ES UN NUEVO RECORD!", Toast.LENGTH_SHORT);
                toast1.show();
            }else{
                Toast toast1 = Toast.makeText(getApplicationContext(), "RESPUESTA INCORRECTA!", Toast.LENGTH_SHORT);
                toast1.show();
            }
            finish();
        }
    }
    public void imageThreeVoid(View view) {
        if(tipoCorrecto == 3){
            puntuacion++;
            respuesta.setText("Puntuacion: "+puntuacion);
            loadGame();
            Snackbar.make(view, "CORRECTO!", Snackbar.LENGTH_LONG).show();
        }else{
            if(puntuacion>record){
                SharedPreferences prefs =getApplicationContext().getSharedPreferences("RECORD", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =prefs.edit();
                editor.putInt("record", puntuacion);
                editor.commit();
                Toast toast1 = Toast.makeText(getApplicationContext(), "ES UN NUEVO RECORD!", Toast.LENGTH_SHORT);
                toast1.show();
            }else{
                Toast toast1 = Toast.makeText(getApplicationContext(), "RESPUESTA INCORRECTA!", Toast.LENGTH_SHORT);
                toast1.show();
            }
            finish();
        }
    }
    public void imageFourVoid(View view) {
        if(tipoCorrecto == 4){
            puntuacion++;
            respuesta.setText("Puntuacion: "+puntuacion);
            loadGame();
            Snackbar.make(view, "CORRECTO!", Snackbar.LENGTH_LONG).show();
        }else{
            if(puntuacion>record){
                SharedPreferences prefs =getApplicationContext().getSharedPreferences("RECORD", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =prefs.edit();
                editor.putInt("record", puntuacion);
                editor.commit();
                Toast toast1 = Toast.makeText(getApplicationContext(), "ES UN NUEVO RECORD!", Toast.LENGTH_SHORT);
                toast1.show();
                Snackbar.make(view, "ES UN NUEVO RECORD!", Snackbar.LENGTH_LONG).show();
            }else{
                Toast toast1 = Toast.makeText(getApplicationContext(), "RESPUESTA INCORRECTA!", Toast.LENGTH_SHORT);
                toast1.show();
            }
            finish();
        }
    }
}
