package com.valentelmadafaka.pokemonapp.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.valentelmadafaka.pokemonapp.R;

import java.util.ArrayList;
import java.util.List;

public class PokemonsArray extends ArrayAdapter<Pokemon> {

    private Context context;
    private List<Pokemon> pokemonList;

    public PokemonsArray(Context context, int resource, ArrayList<Pokemon> pokemons){
        super(context, resource, pokemons);
        this.context = context;
        this.pokemonList = pokemons;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Pokemon pokemon = pokemonList.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.pokemon_pokedex, null);
        TextView numero = (TextView) view.findViewById(R.id.Numero);
        TextView nombre = (TextView) view.findViewById(R.id.Nombre);
        ImageView tipo1 = (ImageView) view.findViewById(R.id.Tipo1);
        ImageView tipo2 = (ImageView) view.findViewById(R.id.Tipo2);
        ImageView imagen = (ImageView) view.findViewById(R.id.Imagen);

        numero.setText(pokemon.getId());
        nombre.setText(pokemon.getNombre());
        if(pokemon.getTipoDual() == null) {
            int tipoID = context.getResources().getIdentifier(pokemon.getTipo().getIcon(), "drawable", context.getPackageName());
            tipo1.setImageResource(tipoID);
        }
        else{
            int tipoID1 = context.getResources().getIdentifier(pokemon.getTipoDual().getTipo1().getIcon(),"drawable", context.getPackageName());
            int tipoID2 = context.getResources().getIdentifier(pokemon.getTipoDual().getTipo2().getIcon(),"drawable", context.getPackageName());
            tipo1.setImageResource(tipoID1);
            tipo2.setImageResource(tipoID2);
        }
        int imageID = context.getResources().getIdentifier(pokemon.getImg(), "drawable", context.getPackageName());
        imagen.setImageResource(imageID);
        return view;
    }
}
