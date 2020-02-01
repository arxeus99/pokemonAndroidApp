package com.valentelmadafaka.pokemonapp;

import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.valentelmadafaka.pokemonapp.dataBase.DBInterface;
import com.valentelmadafaka.pokemonapp.model.Pokemon;

import java.util.List;

public class InfoFragment extends Fragment {

    DBInterface db;
    Cursor c;
    Long idPokemon;
    String nombre;
    String descripcion;
    String tipo1;
    String tipo2;
    String img;
    private List<Pokemon> pokemonList;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // layout de la llista
        return inflater.inflate(R.layout.fragment_info, container, false);
    }
    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
    }

    public void mostrarDetall(String id) {
        TextView idn = getView().findViewById(R.id.IDPokemon);
        TextView nombreP = getView().findViewById(R.id.NombrePokemon);
        ImageView pokemonI = getView().findViewById(R.id.ImagenPokemon);
        TextView desc = getView().findViewById(R.id.DescripcionPokemon);
        ImageView type1 = getView().findViewById(R.id.Tipo1);
        ImageView type2 = getView().findViewById(R.id.Tipo2);

        idPokemon = Long.parseLong(id);
        db = new DBInterface(getContext());
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
        int resID = res.getIdentifier(img , "drawable", getActivity().getPackageName());
        pokemonI.setImageResource(resID);
        if(cant.equals("0")) {
            int t1 = res.getIdentifier(tipo1 , "drawable", getActivity().getPackageName());
            type1.setImageResource(t1);
            type2.setImageResource(0);
        } else {
            int t1 = res.getIdentifier(tipo1 , "drawable", getActivity().getPackageName());
            type1.setImageResource(t1);
            int t2 = res.getIdentifier(tipo2 , "drawable", getActivity().getPackageName());
            type2.setImageResource(t2);
        }
    }
}
