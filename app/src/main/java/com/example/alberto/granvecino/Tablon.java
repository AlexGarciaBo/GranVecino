package com.example.alberto.granvecino;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class Tablon extends AppCompatActivity {
    ListView anun;
    Adapter michica;
    Tablon context;

    ArrayList<Anuncio>anuncios= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablon);
        context = this;
        anun =(ListView)findViewById(R.id.tablonLV);

        /*Anuncio a1= new Anuncio("Pepito","caligiuro","21","farmaceutico","vendo medicinas");
        Anuncio a2 = new Anuncio("Mi chica","Caligiuro","22","estudiante","estudio");
        anuncios.add(a1);
        anuncios.add(a2);*/

        /* Leemos los anuncios conectandonos a firebase. No intentes hacer esto en tu casa sin
        * supervision de un informatico
        * */
       /*Nos conectamos con la base de datos de firebase*/
        FirebaseDatabase database = FirebaseDatabase.getInstance();
                /*Obtenemos la refencia de anuncios*/
        DatabaseReference myRef = database.getReference("Anuncios");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    String trabajo = (String) messageSnapshot.child("trabajo").getValue();
                    String anunciante = (String) messageSnapshot.child("anunciante").getValue();
                    String descripcion = (String) messageSnapshot.child("descripcion").getValue();
                    String tipo = (String) messageSnapshot.child("tipo").getValue();
                    anuncios.add(new Anuncio(trabajo,descripcion,anunciante,tipo));
                }

                michica = new AdaptadorTab(context,anuncios);
                anun.setAdapter((ListAdapter) michica);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
