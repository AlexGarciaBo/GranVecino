package com.example.alberto.granvecino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Perfil extends AppCompatActivity {
    ArrayList<Persona>datos;

    public Perfil(ArrayList<Persona> datos) {
        this.datos = datos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        TextView nombre=(TextView)findViewById(R.id.nombreTV);
        TextView apellidos=(TextView)findViewById(R.id.apellidosTV);
        TextView edad =(TextView)findViewById(R.id.edadTV);
        TextView trabCom=(TextView)findViewById(R.id.trabComTV);


    }
}
