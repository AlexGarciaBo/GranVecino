package com.example.alberto.granvecino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Solicitar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar);

        Button solicitar = (Button) findViewById(R.id.solicitarBTN);

        solicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText descr = (EditText) findViewById(R.id.descET);
                EditText trabajo = (EditText) findViewById(R.id.editText2);

                String trabajoT = trabajo.getText().toString();
                String descrT = descr.getText().toString();

                /*Nos conectamos con la base de datos de firebase*/
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                /*Obtenemos la refencia de anuncios*/
                DatabaseReference myRef = database.getReference("Anuncios");

                /*Obtenemos el usuario conectado a la aplicacion y logado*/
                FirebaseAuth  yo = FirebaseAuth.getInstance();
                FirebaseUser currentUser = yo.getCurrentUser();
                String me = "";
                if (currentUser != null) {
                    me = currentUser.getEmail(); //obtenemos su mail
                }
                /*Creamos el anuncio para subirlo a la BD*/
                Anuncio anuncio = new Anuncio(trabajoT,descrT,me,"demanda");

                try {
                    /* Subimos a la base de datos mediante push()*/
                    myRef.push().setValue(anuncio);
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Gracias, su peticion ha sido añadida", Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
