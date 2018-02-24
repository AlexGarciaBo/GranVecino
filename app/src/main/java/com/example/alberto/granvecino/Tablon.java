package com.example.alberto.granvecino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Tablon extends AppCompatActivity {
    ListView anun;
    Adapter michica;
    ArrayList<Anuncio>anuncios= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablon);

        anun =(ListView)findViewById(R.id.tablonLV);

        Anuncio a1= new Anuncio("Pepito","caligiuro","21","farmaceutico","vendo medicinas");
        Anuncio a2 = new Anuncio("Mi chica","Caligiuro","22","estudiante","estudio");
        anuncios.add(a1);
        anuncios.add(a2);

        michica = new AdaptadorTab(this,anuncios);
        anun.setAdapter((ListAdapter) michica);

    }
}
