package com.valentelmadafaka.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
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
        Intent intent = getIntent();
        final String id = intent.getStringExtra("id");

        idPokemon = Long.parseLong(id);
        db = new DBInterface(this);
        db.obre();
        c = db.obtenirPokemon(idPokemon);
        idPokemon = c.getLong(0);
        nombre = c.getString(1);
        descripcion = c.getString(2);
        String cant = c.getString(3);
        String linea = c.getString(7);
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
        final String[] line = linea.split(",");

        if(line.length == 2) {
            if(line[1].equals("uno")) {
                setContentView(R.layout.activity_pokemon__infouno);
                TextView idn = findViewById(R.id.IDPokemon);
                TextView nombreP = findViewById(R.id.NombrePokemon);
                ImageView pokemonI = findViewById(R.id.ImagenPokemon);
                TextView desc = findViewById(R.id.DescripcionPokemon);
                ImageView type1 = findViewById(R.id.Tipo1);
                ImageView type2 = findViewById(R.id.Tipo2);
                ImageView uno = findViewById(R.id.imageView15);
                pokedex = findViewById(R.id.imageView3);
                moveAnimation();
                idn.setText(Long.toString(idPokemon));
                nombreP.setText(nombre);
                desc.setText(descripcion);
                Resources res = getResources();
                int resID = res.getIdentifier(img, "drawable", getPackageName());
                pokemonI.setImageResource(resID);
                if (cant.equals("0")) {
                    int t1 = res.getIdentifier(tipo1, "drawable", getPackageName());
                    type1.setImageResource(t1);
                } else {
                    int t1 = res.getIdentifier(tipo1, "drawable", getPackageName());
                    type1.setImageResource(t1);
                    int t2 = res.getIdentifier(tipo2, "drawable", getPackageName());
                    type2.setImageResource(t2);
                }
                moveAnimation();
            } else if(line[1].equals("cast")) {
                setContentView(R.layout.activity_pokemon__infocast);
                TextView idn = findViewById(R.id.IDPokemon);
                TextView nombreP = findViewById(R.id.NombrePokemon);
                ImageView pokemonI = findViewById(R.id.ImagenPokemon);
                TextView desc = findViewById(R.id.DescripcionPokemon);
                ImageView type1 = findViewById(R.id.Tipo1);
                ImageView type2 = findViewById(R.id.Tipo2);
                ImageView uno = findViewById(R.id.imageView15);
                pokedex = findViewById(R.id.imageView3);
                moveAnimation();
                idn.setText(Long.toString(idPokemon));
                nombreP.setText(nombre);
                desc.setText(descripcion);
                Resources res = getResources();
                int resID = res.getIdentifier(img, "drawable", getPackageName());
                pokemonI.setImageResource(resID);
                if (cant.equals("0")) {
                    int t1 = res.getIdentifier(tipo1, "drawable", getPackageName());
                    type1.setImageResource(t1);
                } else {
                    int t1 = res.getIdentifier(tipo1, "drawable", getPackageName());
                    type1.setImageResource(t1);
                    int t2 = res.getIdentifier(tipo2, "drawable", getPackageName());
                    type2.setImageResource(t2);
                }
                moveAnimation();
            } else if(line[1].equals("deox")) {
                setContentView(R.layout.activity_pokemon__infodeox);
                TextView idn = findViewById(R.id.IDPokemon);
                TextView nombreP = findViewById(R.id.NombrePokemon);
                ImageView pokemonI = findViewById(R.id.ImagenPokemon);
                TextView desc = findViewById(R.id.DescripcionPokemon);
                ImageView type1 = findViewById(R.id.Tipo1);
                ImageView type2 = findViewById(R.id.Tipo2);
                ImageView uno = findViewById(R.id.imageView15);
                pokedex = findViewById(R.id.imageView3);
                moveAnimation();
                idn.setText(Long.toString(idPokemon));
                nombreP.setText(nombre);
                desc.setText(descripcion);
                Resources res = getResources();
                int resID = res.getIdentifier(img, "drawable", getPackageName());
                pokemonI.setImageResource(resID);
                if (cant.equals("0")) {
                    int t1 = res.getIdentifier(tipo1, "drawable", getPackageName());
                    type1.setImageResource(t1);
                } else {
                    int t1 = res.getIdentifier(tipo1, "drawable", getPackageName());
                    type1.setImageResource(t1);
                    int t2 = res.getIdentifier(tipo2, "drawable", getPackageName());
                    type2.setImageResource(t2);
                }
                moveAnimation();
            }
        } else if(line.length == 1) {
            setContentView(R.layout.activity_pokemon__info1ev);
            TextView idn = findViewById(R.id.IDPokemon);
            TextView nombreP = findViewById(R.id.NombrePokemon);
            ImageView pokemonI = findViewById(R.id.ImagenPokemon);
            TextView desc = findViewById(R.id.DescripcionPokemon);
            ImageView type1 = findViewById(R.id.Tipo1);
            ImageView type2 = findViewById(R.id.Tipo2);
            pokedex = findViewById(R.id.imageView3);
            moveAnimation();
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

        } else if(line.length == 3) {
            setContentView(R.layout.activity_pokemon__info2ev);
            TextView idn = findViewById(R.id.IDPokemon);
            TextView nombreP = findViewById(R.id.NombrePokemon);
            ImageView pokemonI = findViewById(R.id.ImagenPokemon);
            TextView desc = findViewById(R.id.DescripcionPokemon);
            ImageView type1 = findViewById(R.id.Tipo1);
            ImageView type2 = findViewById(R.id.Tipo2);
            ImageView evo1 = findViewById(R.id.imageView4);
            ImageView evo2 = findViewById(R.id.imageView6);
            TextView cond = findViewById(R.id.condicion);
            pokedex = findViewById(R.id.imageView3);

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
            cond.setText(line[1]);
            resID = res.getIdentifier(line[0] , "drawable", getPackageName());
            evo1.setImageResource(resID);
            evo1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[0];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                    }
                }
            });
            resID = res.getIdentifier(line[2] , "drawable", getPackageName());
            evo2.setImageResource(resID);
            evo2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[2];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            moveAnimation();

        } else if(line.length == 5) {
            setContentView(R.layout.activity_pokemon__info3ev);
            TextView idn = findViewById(R.id.IDPokemon);
            TextView nombreP = findViewById(R.id.NombrePokemon);
            ImageView pokemonI = findViewById(R.id.ImagenPokemon);
            TextView desc = findViewById(R.id.DescripcionPokemon);
            ImageView type1 = findViewById(R.id.Tipo1);
            ImageView type2 = findViewById(R.id.Tipo2);
            ImageView evo1 = findViewById(R.id.imageView4);
            ImageView evo2 = findViewById(R.id.imageView6);
            ImageView evo3 = findViewById(R.id.imageView7);
            TextView cond = findViewById(R.id.condicion);
            TextView cond2 = findViewById(R.id.condicion2);
            pokedex = findViewById(R.id.imageView3);

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
            cond.setText(line[1]);
            cond2.setText(line[3]);
            resID = res.getIdentifier(line[0] , "drawable", getPackageName());
            evo1.setImageResource(resID);
            evo1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[0];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[2] , "drawable", getPackageName());
            evo2.setImageResource(resID);
            evo2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[2];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[4] , "drawable", getPackageName());
            evo3.setImageResource(resID);
            evo3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[4];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            moveAnimation();

        } else if(line[5].equals("odd")) {
            setContentView(R.layout.activity_pokemon__infoodd);
            TextView idn = findViewById(R.id.IDPokemon);
            TextView nombreP = findViewById(R.id.NombrePokemon);
            ImageView pokemonI = findViewById(R.id.ImagenPokemon);
            TextView desc = findViewById(R.id.DescripcionPokemon);
            ImageView type1 = findViewById(R.id.Tipo1);
            ImageView type2 = findViewById(R.id.Tipo2);
            ImageView evo1 = findViewById(R.id.imageView4);
            ImageView evo2 = findViewById(R.id.imageView6);
            ImageView evo3 = findViewById(R.id.imageView11);
            ImageView evo4 = findViewById(R.id.imageView12);
            TextView cond = findViewById(R.id.condicion);
            TextView cond2 = findViewById(R.id.condicion2);
            TextView cond3 = findViewById(R.id.condicion3);
            pokedex = findViewById(R.id.imageView3);

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
            cond.setText(line[1]);
            cond2.setText(line[3]);
            cond3.setText(line[6]);
            resID = res.getIdentifier(line[0] , "drawable", getPackageName());
            evo1.setImageResource(resID);
            evo1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[0];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[2] , "drawable", getPackageName());
            evo2.setImageResource(resID);
            evo2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[2];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[4] , "drawable", getPackageName());
            evo3.setImageResource(resID);
            evo3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[4];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[7] , "drawable", getPackageName());
            evo4.setImageResource(resID);
            evo4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[7];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            moveAnimation();
        } else if(line[5].equals("slow")) {
            setContentView(R.layout.activity_pokemon__infoslow);
            TextView idn = findViewById(R.id.IDPokemon);
            TextView nombreP = findViewById(R.id.NombrePokemon);
            ImageView pokemonI = findViewById(R.id.ImagenPokemon);
            TextView desc = findViewById(R.id.DescripcionPokemon);
            ImageView type1 = findViewById(R.id.Tipo1);
            ImageView type2 = findViewById(R.id.Tipo2);
            ImageView evo1 = findViewById(R.id.imageView4);
            ImageView evo2 = findViewById(R.id.imageView11);
            ImageView evo3 = findViewById(R.id.imageView12);
            TextView cond = findViewById(R.id.condicion2);
            TextView cond2 = findViewById(R.id.condicion3);
            pokedex = findViewById(R.id.imageView3);

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
            cond.setText(line[1]);
            cond2.setText(line[3]);
            resID = res.getIdentifier(line[0] , "drawable", getPackageName());
            evo1.setImageResource(resID);
            evo1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[0];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[2] , "drawable", getPackageName());
            evo2.setImageResource(resID);
            evo2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[2];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[4] , "drawable", getPackageName());
            evo3.setImageResource(resID);
            evo3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[4];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            moveAnimation();

        } else if(line[5].equals("tyr")) {
            setContentView(R.layout.activity_pokemon__infotyr);
            TextView idn = findViewById(R.id.IDPokemon);
            TextView nombreP = findViewById(R.id.NombrePokemon);
            ImageView pokemonI = findViewById(R.id.ImagenPokemon);
            TextView desc = findViewById(R.id.DescripcionPokemon);
            ImageView type1 = findViewById(R.id.Tipo1);
            ImageView type2 = findViewById(R.id.Tipo2);
            ImageView evo1 = findViewById(R.id.imageView4);
            ImageView evo2 = findViewById(R.id.imageView11);
            ImageView evo3 = findViewById(R.id.imageView12);
            ImageView evo4 = findViewById(R.id.imageView14);
            TextView cond = findViewById(R.id.condicion2);
            TextView cond2 = findViewById(R.id.condicion3);
            TextView cond3 = findViewById(R.id.condicion4);
            pokedex = findViewById(R.id.imageView3);
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
            cond.setText(line[1]);
            cond2.setText(line[3]);
            cond3.setText(line[6]);
            resID = res.getIdentifier(line[0] , "drawable", getPackageName());
            evo1.setImageResource(resID);
            evo1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[0];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[2] , "drawable", getPackageName());
            evo2.setImageResource(resID);
            evo2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[2];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[4] , "drawable", getPackageName());
            evo3.setImageResource(resID);
            evo3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[4];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[7] , "drawable", getPackageName());
            evo4.setImageResource(resID);
            evo4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[7];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
        } else if(line[5].equals("eve")) {
            setContentView(R.layout.activity_pokemon__infoeve);
            TextView idn = findViewById(R.id.IDPokemon);
            TextView nombreP = findViewById(R.id.NombrePokemon);
            ImageView pokemonI = findViewById(R.id.ImagenPokemon);
            TextView desc = findViewById(R.id.DescripcionPokemon);
            ImageView type1 = findViewById(R.id.Tipo1);
            ImageView type2 = findViewById(R.id.Tipo2);
            ImageView evo1 = findViewById(R.id.imageView4);
            ImageView evo2 = findViewById(R.id.imageView5);
            ImageView evo3 = findViewById(R.id.imageView6);
            ImageView evo4 = findViewById(R.id.imageView7);
            ImageView evo5 = findViewById(R.id.imageView8);
            ImageView evo6 = findViewById(R.id.imageView9);
            TextView cond = findViewById(R.id.condicion);
            TextView cond2 = findViewById(R.id.condicion2);
            TextView cond3 = findViewById(R.id.condicion3);
            TextView cond4 = findViewById(R.id.condicion4);
            TextView cond5 = findViewById(R.id.condicion5);
            pokedex = findViewById(R.id.imageView3);
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
            cond.setText(line[1]);
            cond2.setText(line[3]);
            cond3.setText(line[6]);
            cond4.setText(line[8]);
            cond5.setText(line[10]);
            resID = res.getIdentifier(line[0] , "drawable", getPackageName());
            evo1.setImageResource(resID);
            evo1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[0];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[2] , "drawable", getPackageName());
            evo2.setImageResource(resID);
            evo2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[2];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[4] , "drawable", getPackageName());
            evo3.setImageResource(resID);
            evo3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[4];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[7] , "drawable", getPackageName());
            evo4.setImageResource(resID);
            evo4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[7];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[9] , "drawable", getPackageName());
            evo5.setImageResource(resID);
            evo5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[9];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[11] , "drawable", getPackageName());
            evo6.setImageResource(resID);
            evo6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[11];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            moveAnimation();
        }else if(line[5].equals("wurm")) {
            setContentView(R.layout.activity_pokemon__infowurm);
            TextView idn = findViewById(R.id.IDPokemon);
            TextView nombreP = findViewById(R.id.NombrePokemon);
            ImageView pokemonI = findViewById(R.id.ImagenPokemon);
            TextView desc = findViewById(R.id.DescripcionPokemon);
            ImageView type1 = findViewById(R.id.Tipo1);
            ImageView type2 = findViewById(R.id.Tipo2);
            ImageView evo1 = findViewById(R.id.imageView4);
            ImageView evo2 = findViewById(R.id.imageView9);
            ImageView evo3 = findViewById(R.id.imageView13);
            ImageView evo4 = findViewById(R.id.imageView10);
            ImageView evo5 = findViewById(R.id.imageView14);
            TextView cond = findViewById(R.id.condicion);
            TextView cond2 = findViewById(R.id.condicion2);
            TextView cond3 = findViewById(R.id.condicion1);
            TextView cond4 = findViewById(R.id.condicion3);
            pokedex = findViewById(R.id.imageView3);
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
            cond.setText(line[1]);
            cond2.setText(line[3]);
            cond3.setText(line[6]);
            cond4.setText(line[8]);
            resID = res.getIdentifier(line[0] , "drawable", getPackageName());
            evo1.setImageResource(resID);
            evo1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[0];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[2] , "drawable", getPackageName());
            evo2.setImageResource(resID);
            evo2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[2];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[4] , "drawable", getPackageName());
            evo3.setImageResource(resID);
            evo3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[4];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[7] , "drawable", getPackageName());
            evo4.setImageResource(resID);
            evo4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[7];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            resID = res.getIdentifier(line[9] , "drawable", getPackageName());
            evo5.setImageResource(resID);
            evo5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String aux = line[9];
                    if(id.equals(aux.replace("p",""))){

                    }else {
                        Intent i = new Intent(Pokemon_Info.this, Pokemon_Info.class);
                        i.putExtra("id", aux.replace("p", ""));
                        startActivity(i);
                        finish();
                    }
                }
            });
            moveAnimation();
        }
    }

    public void moveAnimation() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(pokedex, "translationX", 1300f);
        animation.setDuration(2000);
        animation.start();
    }
}
