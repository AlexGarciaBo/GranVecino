package com.example.alberto.granvecino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Perfil extends AppCompatActivity {
    TextView nombre, apellidos, edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        nombre =(TextView)findViewById(R.id.tvNombre);
        apellidos =(TextView)findViewById(R.id.tvApellidos);
        edad =(TextView)findViewById(R.id.tvEdad);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
                /*Obtenemos la refencia de anuncios*/
        DatabaseReference myRef = database.getReference("Perfil");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    String miNombre = (String) messageSnapshot.child("nombre").getValue();
                    nombre.setText("Nombre: " + miNombre);
                    String misApellidos = (String) messageSnapshot.child("apellidos").getValue();
                    apellidos.setText("Apellidos: " + misApellidos);
                    String miEdad = (String) messageSnapshot.child("edad").getValue();
                    edad.setText("Edad: " + miEdad);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void editar(View view){
        startActivity(new Intent(Perfil.this, EditarPerfil.class));
    }
}
