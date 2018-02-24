package com.example.alberto.granvecino;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Favoritos extends AppCompatActivity {
    ListView fav;
    Adapter adapter;
    ArrayList<Persona> personas= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        fav=(ListView)findViewById(R.id.favList);


        Persona p1=new Persona("pepe","perez","20");
        Persona p2=new Persona("pepa","sanchez","35");

        personas.add(p1);
        personas.add(p2);

        adapter= new AdaptadorFav(this,personas);
        fav.setAdapter((ListAdapter) adapter);



    }
}
