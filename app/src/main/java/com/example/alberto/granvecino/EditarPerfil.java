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

public class EditarPerfil extends AppCompatActivity {
    Button confirmar;
    EditText etNombre, etApellidos, etEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);
        confirmar = (Button) findViewById(R.id.btnConfirmar);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellidos = (EditText) findViewById(R.id.etApellidos);
        etEdad = (EditText) findViewById(R.id.etEdad);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = etNombre.getText().toString();
                String apellidos = etApellidos.getText().toString();
                String edad = etEdad.getText().toString();

                /*Nos conectamos con la base de datos de firebase*/
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                /*Obtenemos la refencia de anuncios*/
                DatabaseReference myRef = database.getReference("Perfil");

                /*Obtenemos el usuario conectado a la aplicacion y logado*/
                FirebaseAuth yo = FirebaseAuth.getInstance();
                FirebaseUser currentUser = yo.getCurrentUser();
                String me = "";
                if (currentUser != null) {
                    me = currentUser.getEmail(); //obtenemos su mail
                }
                /*Creamos el anuncio para subirlo a la BD*/
                Persona persona = new Persona(nombre, apellidos, edad);

                try {
                    /* Subimos a la base de datos mediante push()*/
                    myRef.push().setValue(persona);
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Has editado tu perfil", Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}