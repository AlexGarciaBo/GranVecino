package com.example.alberto.granvecino;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.example.alberto.granvecino.MainActivity;
import com.example.alberto.granvecino.R;


public class Registro extends AppCompatActivity {
    Button botonRegistrar;
    EditText Email_Registro, Contraseña_Registro, Repetir_Contraseña_Registro, Repetir_Email_Registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        botonRegistrar = (Button) findViewById(R.id.btnRegistro);
        Email_Registro = (EditText) findViewById(R.id.email);
        Repetir_Email_Registro = (EditText) findViewById(R.id.re_email);
        Contraseña_Registro = (EditText) findViewById(R.id.new_pass);
        Repetir_Contraseña_Registro = (EditText) findViewById(R.id.re_pass);

        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Email_Registro.getText().toString().equals("") || Repetir_Email_Registro.getText().toString().equals("") || Contraseña_Registro.getText().toString().equals("") || Repetir_Contraseña_Registro.getText().toString().equals("")){
                    Toast toast = Toast.makeText(Registro.this, "Rellene los campos", Toast.LENGTH_SHORT);
                    toast.show();
                }else if(Email_Registro.getText().toString().equals(Repetir_Email_Registro.getText().toString()) == false){
                    Toast toast = Toast.makeText(Registro.this, "El email no coincide", Toast.LENGTH_SHORT);
                    toast.show();
                }else if(Contraseña_Registro.getText().toString().equals(Repetir_Contraseña_Registro.getText().toString()) == false){
                    Toast toast = Toast.makeText(Registro.this, "Las contraseñas no son iguales", Toast.LENGTH_SHORT);
                    toast.show();
                }else if(Contraseña_Registro.getText().toString().trim().length() < 6){
                    Toast toast = Toast.makeText(Registro.this, "Longitud minima de contraseña: 6 caracteres", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(Email_Registro.getText().toString(), Contraseña_Registro.getText().toString())
                            .addOnCompleteListener(Registro.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(Registro.this, "Fallo al registrar usuario, intentelo de nuevo",
                                                Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(Registro.this, "Registrado correctamente",
                                                Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Registro.this, MainActivity.class));
                                        finish();
                                    }
                                }
                            });
                }
            }
        });

    }
}
