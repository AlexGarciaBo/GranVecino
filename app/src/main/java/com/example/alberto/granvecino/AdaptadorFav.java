package com.example.alberto.granvecino;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by alberto on 14/02/2018.
 */

public class AdaptadorFav extends BaseAdapter {
    private Context cont;
    private ArrayList<Persona> datos;


    public AdaptadorFav(Favoritos favoritos, ArrayList<Persona> personas ) {
        this.cont=favoritos;
        this.datos=personas;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {
        View vista=convertView;
        if(vista==null){
            LayoutInflater inflater= LayoutInflater.from(cont);
            vista=inflater.inflate(R.layout.fav_element_list,null);
        }
        TextView nombre=(TextView)vista.findViewById(R.id.nombreTV);
        TextView apelllidos=(TextView)vista.findViewById(R.id.apellidosTV);

        TextView edad=(TextView)vista.findViewById(R.id.edadTV);

        nombre.setText(datos.get(position).getNombre());
        apelllidos.setText(datos.get(position).getApellidos());
        edad.setText(datos.get(position).edad);

        return vista;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }





}
