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
        View view = inflater.inflate(R.layout.pokemon_llista, null);
        TextView nom = (TextView) view.findViewById(R.id.nom);
        TextView tipus = (TextView) view.findViewById(R.id.tipus);
        TextView descripcio = (TextView) view.findViewById(R.id.descripcio);
        ImageView imatge = (ImageView) view.findViewById(R.id.imatge);

        nom.setText(pokemon.getNombre());
        if(pokemon.getTipoDual() == null)
            tipus.setText(pokemon.getTipo().getNombre());
        else
            tipus.setText(pokemon.getTipoDual().getTipo1().getNombre()+", "+pokemon.getTipoDual().getTipo2().getNombre());
        descripcio.setText(pokemon.getDescripcion());
        int imageID = context.getResources().getIdentifier(pokemon.getImg(), "drawable", context.getPackageName());
        imatge.setImageResource(imageID);
        return view;
    }
}
