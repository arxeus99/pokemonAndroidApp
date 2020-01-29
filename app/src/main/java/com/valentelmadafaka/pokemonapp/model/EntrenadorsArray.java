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

public class EntrenadorsArray extends ArrayAdapter<Entrenador> {

    private Context context;
    private List<Entrenador> entrenadorList;

    public EntrenadorsArray(Context context, int resource, ArrayList<Entrenador> entrenadors){
        super(context, resource, entrenadors);
        this.context = context;
        this.entrenadorList = entrenadors;
    }

    public View getView(int position, View convertViewm, ViewGroup parent){
        Entrenador entrenador = entrenadorList.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.ficha_entrenador, null);
        TextView nombre = (TextView) view.findViewById(R.id.name);
        ImageView imageView = (ImageView) view.findViewById(R.id.imagen);
        ImageView p1 = (ImageView) view.findViewById(R.id.pokemon1);
        ImageView p2 = (ImageView) view.findViewById(R.id.pokemon2);
        ImageView p3 = (ImageView) view.findViewById(R.id.pokemon3);
        ImageView p4 = (ImageView) view.findViewById(R.id.pokemon4);
        ImageView p5 = (ImageView) view.findViewById(R.id.pokemon5);
        ImageView p6 = (ImageView) view.findViewById(R.id.pokemon6);

        nombre.setText(entrenador.getNombre());
        int imageID = context.getResources().getIdentifier(entrenador.getImagen(), "drawable", context.getOpPackageName());
        imageView.setImageResource(imageID);
        imageID = context.getResources().getIdentifier(entrenador.getEquipo()[0].getImgg(), "drawable", context.getOpPackageName());
        p1.setImageResource(imageID);
        imageID = context.getResources().getIdentifier(entrenador.getEquipo()[1].getImgg(), "drawable", context.getOpPackageName());
        p2.setImageResource(imageID);
        imageID = context.getResources().getIdentifier(entrenador.getEquipo()[2].getImgg(), "drawable", context.getOpPackageName());
        p3.setImageResource(imageID);
        imageID = context.getResources().getIdentifier(entrenador.getEquipo()[3].getImgg(), "drawable", context.getOpPackageName());
        p4.setImageResource(imageID);
        imageID = context.getResources().getIdentifier(entrenador.getEquipo()[4].getImgg(), "drawable", context.getOpPackageName());
        p5.setImageResource(imageID);
        imageID = context.getResources().getIdentifier(entrenador.getEquipo()[5].getImgg(), "drawable", context.getOpPackageName());
        p6.setImageResource(imageID);



        return view;
    }
}
