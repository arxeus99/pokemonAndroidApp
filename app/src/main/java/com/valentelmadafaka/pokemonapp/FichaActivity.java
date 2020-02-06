package com.valentelmadafaka.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.valentelmadafaka.pokemonapp.dataBase.DBInterface;
import com.valentelmadafaka.pokemonapp.model.Entrenador;
import com.valentelmadafaka.pokemonapp.model.EntrenadorsArray;
import com.valentelmadafaka.pokemonapp.model.Pokemon;
import com.valentelmadafaka.pokemonapp.model.Tipo;
import com.valentelmadafaka.pokemonapp.model.TipoDual;

import java.util.ArrayList;

public class FichaActivity extends AppCompatActivity {


    DBInterface db;
    String picture;
    ImageView imageView;
    EditText nombre;
    ArrayList<Pokemon> pokemons;
    AutoCompleteTextView pokemon1;
    AutoCompleteTextView pokemon2;
    AutoCompleteTextView pokemon3;
    AutoCompleteTextView pokemon4;
    AutoCompleteTextView pokemon5;
    AutoCompleteTextView pokemon6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DBInterface(this);
        db.obre();

        pokemons = new ArrayList<>();
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
        if(!db.isEntrenadorEmpty()){
            setContentView(R.layout.activity_ficha);
            final ArrayList<Entrenador> entrenadors = new ArrayList<>();
            c = db.obtenirEntrendaor();
            c.moveToFirst();
            while (!c.isAfterLast()){
                Entrenador entrenador = new Entrenador();
                entrenador.setId(c.getString(0));
                entrenador.setNombre(c.getString(1));
                entrenador.setImagen(c.getString(2));
                String[] equipo = c.getString(3).split(",");
                Pokemon p1 = new Pokemon();
                Pokemon p2 = new Pokemon();
                Pokemon p3 = new Pokemon();
                Pokemon p4 = new Pokemon();
                Pokemon p5 = new Pokemon();
                Pokemon p6 = new Pokemon();
                for(Pokemon p: pokemons){
                    if(p.getId().equals(equipo[0])){
                        p1 = p;
                    }else if(p.getId().equals(equipo[1])){
                        p2 = p;
                    }else if(p.getId().equals(equipo[2])){
                        p3 = p;
                    }else if(p.getId().equals(equipo[3])){
                        p4 = p;
                    }else if(p.getId().equals(equipo[4])){
                        p5 = p;
                    }else if(p.getId().equals(equipo[5])){
                        p6 = p;
                    }
                }
                Pokemon[] equipoPokemon = {p1,p2,p3,p4,p5,p6};
                entrenador.setEquipo(equipoPokemon);
                entrenadors.add(entrenador);
                c.moveToNext();
            }
            final ListView listView = findViewById(R.id.list_view2);
            final EntrenadorsArray entrenadorsArray = new EntrenadorsArray(this, R.layout.ficha_entrenador, entrenadors);
            listView.setAdapter(entrenadorsArray);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                    PopupMenu popup = new PopupMenu(FichaActivity.this, view);
                    popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getTitle().toString()){
                                case "Editar":{
                                    setContentView(R.layout.cuestionario_layout);
                                    Button actualizar = (Button)findViewById(R.id.button);
                                    actualizar.setText("Actualizar");

                                    nombre = (EditText) findViewById(R.id.nombreet);
                                    ArrayList<String> nombresPokemon = new ArrayList<>();
                                    for(Pokemon p: pokemons){
                                        nombresPokemon.add(p.getNombre());
                                    }
                                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(FichaActivity.this, android.R.layout.simple_dropdown_item_1line, nombresPokemon);
                                    final Entrenador e = entrenadors.get(position);
                                    pokemon1 = (AutoCompleteTextView)findViewById(R.id.pokemon1tv);
                                    pokemon2 = (AutoCompleteTextView)findViewById(R.id.pokemon2tv);
                                    pokemon3 = (AutoCompleteTextView)findViewById(R.id.pokemon3tv);
                                    pokemon4 = (AutoCompleteTextView)findViewById(R.id.pokemon4tv);
                                    pokemon5 = (AutoCompleteTextView)findViewById(R.id.pokemon5tv);
                                    pokemon6 = (AutoCompleteTextView)findViewById(R.id.pokemon6tv);
                                    pokemon1.setAdapter(adapter);
                                    pokemon2.setAdapter(adapter);
                                    pokemon3.setAdapter(adapter);
                                    pokemon4.setAdapter(adapter);
                                    pokemon5.setAdapter(adapter);
                                    pokemon6.setAdapter(adapter);
                                    pokemon1.setText(e.getEquipo()[0].getNombre());
                                    pokemon2.setText(e.getEquipo()[1].getNombre());
                                    pokemon3.setText(e.getEquipo()[2].getNombre());
                                    pokemon4.setText(e.getEquipo()[3].getNombre());
                                    pokemon5.setText(e.getEquipo()[4].getNombre());
                                    pokemon6.setText(e.getEquipo()[5].getNombre());
                                    imageView = (ImageView) findViewById(R.id.picture);
                                    picture = e.getImagen();
                                    int imageID = getApplicationContext().getResources().getIdentifier(picture, "drawable", getApplicationContext().getPackageName());
                                    imageView.setImageResource(imageID);
                                    nombre.setText(e.getNombre());
                                    actualizar.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Pokemon p1 = new Pokemon();
                                            Pokemon p2 = new Pokemon();
                                            Pokemon p3 = new Pokemon();
                                            Pokemon p4 = new Pokemon();
                                            Pokemon p5 = new Pokemon();
                                            Pokemon p6 = new Pokemon();
                                            for(Pokemon p: pokemons){
                                                if(p.getNombre().equals(pokemon1.getText().toString())){
                                                    p1 = p;
                                                }else if(p.getNombre().equals(pokemon2.getText().toString())){
                                                    p2 = p;
                                                }else if(p.getNombre().equals(pokemon3.getText().toString())){
                                                    p3 = p;
                                                }else if(p.getNombre().equals(pokemon4.getText().toString())){
                                                    p4 = p;
                                                }else if(p.getNombre().equals(pokemon5.getText().toString())){
                                                    p5 = p;
                                                }else if(p.getNombre().equals(pokemon6.getText().toString())){
                                                    p6 = p;
                                                }
                                            }
                                            Pokemon[] equipo = {p1,p2,p3,p4,p5,p6};
                                            String equipoPokemon = "";
                                            for(Pokemon p: equipo){
                                                if(equipoPokemon.isEmpty()){
                                                    equipoPokemon = p.getId();
                                                }else{
                                                    equipoPokemon = equipoPokemon+","+p.getId();
                                                }

                                            }
                                            db.obre();
                                            db.actualitzarEntrenador(e.getId(), nombre.getText().toString(), equipoPokemon, picture);
                                            db.tanca();
                                            Toast.makeText(FichaActivity.this,"Entrenador actualizado", Toast.LENGTH_SHORT).show();
                                            finish();
                                        }
                                    });
                                    break;
                                }
                                case "Borrar":{
                                    db.obre();
                                    db.esborraEntrenador(entrenadors.get(position).getId());
                                    Toast.makeText(FichaActivity.this,"Entrenador borrado", Toast.LENGTH_SHORT).show();
                                    db.tanca();
                                    finish();
                                    break;
                                }
                            }
                            return true;
                        }
                    });

                    popup.show();
                }
            });
        }else{
            setContentView(R.layout.cuestionario_layout);
            nombre = (EditText) findViewById(R.id.nombreet);
            ArrayList<String> nombresPokemon = new ArrayList<>();
            for(Pokemon p: pokemons){
                nombresPokemon.add(p.getNombre());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, nombresPokemon);
            pokemon1 = (AutoCompleteTextView)findViewById(R.id.pokemon1tv);
            pokemon2 = (AutoCompleteTextView)findViewById(R.id.pokemon2tv);
            pokemon3 = (AutoCompleteTextView)findViewById(R.id.pokemon3tv);
            pokemon4 = (AutoCompleteTextView)findViewById(R.id.pokemon4tv);
            pokemon5 = (AutoCompleteTextView)findViewById(R.id.pokemon5tv);
            pokemon6 = (AutoCompleteTextView)findViewById(R.id.pokemon6tv);
            pokemon1.setAdapter(adapter);
            pokemon2.setAdapter(adapter);
            pokemon3.setAdapter(adapter);
            pokemon4.setAdapter(adapter);
            pokemon5.setAdapter(adapter);
            pokemon6.setAdapter(adapter);

            imageView = (ImageView) findViewById(R.id.picture);
            picture = "tr1";
            int imageID = getApplicationContext().getResources().getIdentifier(picture, "drawable", getApplicationContext().getPackageName());
            imageView.setImageResource(imageID);


        }


        db.tanca();

    }


    public void leftVoid(View view) {
        int actualPic = Integer.parseInt(picture.replace("tr",""));
        if(actualPic == 1)
            actualPic = 30;
        else
            actualPic--;
        picture = "tr"+actualPic;
        int imageID = getApplicationContext().getResources().getIdentifier(picture, "drawable", getApplicationContext().getPackageName());
        imageView.setImageResource(imageID);

    }

    public void rightVoid(View view){
        int actualPic = Integer.parseInt(picture.replace("tr",""));
        if(actualPic == 30)
            actualPic = 1;
        else
            actualPic++;
        picture = "tr"+actualPic;
        int imageID = getApplicationContext().getResources().getIdentifier(picture, "drawable", getApplicationContext().getPackageName());
        imageView.setImageResource(imageID);
    }

    public void crearVoid(View view) {
        if(pokemon1.getText().toString().isEmpty() || pokemon2.getText().toString().isEmpty() || pokemon3.getText().toString().isEmpty() || pokemon4.getText().toString().isEmpty() ||
        pokemon5.getText().toString().isEmpty() || pokemon6.getText().toString().isEmpty() || nombre.getText().toString().isEmpty()){
            Snackbar.make(view, "NO PUEDE DEJAR NINGUN CAMPO EN BLANCO!", Snackbar.LENGTH_LONG).show();
        }else{
            Pokemon p1 = new Pokemon();
            Pokemon p2 = new Pokemon();
            Pokemon p3 = new Pokemon();
            Pokemon p4 = new Pokemon();
            Pokemon p5 = new Pokemon();
            Pokemon p6 = new Pokemon();
            for(Pokemon p: pokemons){
                if(p.getNombre().equals(pokemon1.getText().toString())){
                    p1 = p;
                }else if(p.getNombre().equals(pokemon2.getText().toString())){
                    p2 = p;
                }else if(p.getNombre().equals(pokemon3.getText().toString())){
                    p3 = p;
                }else if(p.getNombre().equals(pokemon4.getText().toString())){
                    p4 = p;
                }else if(p.getNombre().equals(pokemon5.getText().toString())){
                    p5 = p;
                }else if(p.getNombre().equals(pokemon6.getText().toString())){
                    p6 = p;
                }
            }
            if(p1.getId() == null || p2.getId() == null || p3.getId() == null || p4.getId() == null || p5.getId() == null || p6.getId() == null){
                Snackbar.make(view, "DEBE INTRODUCIR ALGUNO DE LOS POKEMON SUGERIDOS!", Snackbar.LENGTH_LONG).show();
            }else{
                Pokemon[] equipo = {p1,p2,p3,p4,p5,p6};
                Entrenador entrenador = new Entrenador(nombre.getText().toString(), picture, equipo);
                String equipoPokemon = "";
                for(Pokemon p: equipo){
                    if(equipoPokemon.isEmpty()){
                        equipoPokemon = p.getId();
                    }else{
                        equipoPokemon = equipoPokemon+","+p.getId();
                    }

                }
                db.obre();
                if (db.insereixEntrenador(entrenador.getNombre(), entrenador.getImagen(), equipoPokemon) == -1) {
                    Toast.makeText(this, "Error a l’afegir",
                            Toast.LENGTH_SHORT).show();
                }
                db.tanca();
                Toast.makeText(FichaActivity.this,"Entrenador creado", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }


    public void crearNuevaVoid(View view) {
        setContentView(R.layout.cuestionario_layout);
        nombre = (EditText) findViewById(R.id.nombreet);
        ArrayList<String> nombresPokemon = new ArrayList<>();
        for(Pokemon p: pokemons){
            nombresPokemon.add(p.getNombre());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, nombresPokemon);
        pokemon1 = (AutoCompleteTextView)findViewById(R.id.pokemon1tv);
        pokemon2 = (AutoCompleteTextView)findViewById(R.id.pokemon2tv);
        pokemon3 = (AutoCompleteTextView)findViewById(R.id.pokemon3tv);
        pokemon4 = (AutoCompleteTextView)findViewById(R.id.pokemon4tv);
        pokemon5 = (AutoCompleteTextView)findViewById(R.id.pokemon5tv);
        pokemon6 = (AutoCompleteTextView)findViewById(R.id.pokemon6tv);
        pokemon1.setAdapter(adapter);
        pokemon2.setAdapter(adapter);
        pokemon3.setAdapter(adapter);
        pokemon4.setAdapter(adapter);
        pokemon5.setAdapter(adapter);
        pokemon6.setAdapter(adapter);

        imageView = (ImageView) findViewById(R.id.picture);
        picture = "tr1";
        int imageID = getApplicationContext().getResources().getIdentifier(picture, "drawable", getApplicationContext().getPackageName());
        imageView.setImageResource(imageID);

    }
}
