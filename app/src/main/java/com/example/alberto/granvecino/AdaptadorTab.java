package com.example.alberto.granvecino;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alberto on 16/02/2018.
 */

public class AdaptadorTab extends BaseAdapter {
    ArrayList<Anuncio>datos;
    Context cont;

    public AdaptadorTab(Tablon tablon, ArrayList<Anuncio> anuncios) {
        this.datos = anuncios;
        this.cont = tablon;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista=convertView;
        if(vista==null){
            LayoutInflater inflater= LayoutInflater.from(cont);
            vista=inflater.inflate(R.layout.tablon_element_list,null);
        }
        TextView nombre=(TextView)vista.findViewById(R.id.nombreTV);
        //TextView apellidos=(TextView)vista.findViewById(R.id.apellidosTV);
        //TextView edad=(TextView)vista.findViewById(R.id.edadTV);
        TextView trabajo=(TextView)vista.findViewById(R.id.trabajoTV);
        TextView desc=(TextView)vista.findViewById(R.id.descripcionTV);
        TextView tipo=(TextView)vista.findViewById(R.id.TipoTV);

        nombre.setText("Usuario: " + datos.get(position).getAnunciante());
        tipo.setText("Tipo: " + datos.get(position).getTipo());
        //apellidos.setText("");
        trabajo.setText("Trabajo: " + datos.get(position).getTrabajo());
        //edad.setText("");
        desc.setText("Descripción: " + datos.get(position).getDescripcion());
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
