package com.example.alberto.granvecino;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class Adaptador extends BaseAdapter {
    private static LayoutInflater inflater = null;
    Context context;
    String[][] datos;
    int[]datosImg;

    public Adaptador(Context context, String[][] datos, int[] datosImg) {
        this.context = context;
        this.datos = datos;
        this.datosImg = datosImg;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista= inflater.inflate(R.layout.element_list,null);
        TextView accion = (TextView)vista.findViewById(R.id.accionTV);
        ImageView img= (ImageView)vista.findViewById(R.id.iconoIMG);
        img.setImageResource(datosImg[position]);
        accion.setText(datos[position][1]);

        return vista;
    }
    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
