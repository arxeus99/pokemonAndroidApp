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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PokemonsArray2 extends ArrayAdapter<Pokemon> {

    private Context context;
    private List<Pokemon> pokemonList;

    public PokemonsArray2(Context context, int resource, ArrayList<Pokemon> pokemons){
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
        TextView tipos = (TextView) view.findViewById(R.id.Tipos);
        ImageView imagen = (ImageView) view.findViewById(R.id.Imagen);

        numero.setText(pokemon.getId());
        nombre.setText(pokemon.getNombre());
        if(pokemon.getTipoDual() == null)
            tipos.setText(pokemon.getTipo().getNombre());
        else
            tipos.setText(pokemon.getTipoDual().getTipo1().getNombre()+", "+pokemon.getTipoDual().getTipo2().getNombre());
        int imageID = context.getResources().getIdentifier("p1", "drawable", context.getPackageName());
        imagen.setImageResource(imageID);
        return view;
    }
}
