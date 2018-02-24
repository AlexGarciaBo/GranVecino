package com.example.alberto.granvecino;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
EditText userET, pwdET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView regis=(TextView)findViewById(R.id.registroTV);
        Button login=(Button)findViewById(R.id.loginBTN);
        userET = (EditText)findViewById(R.id.userET);
        pwdET = (EditText)findViewById(R.id.pwdET);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(MainActivity.this, Registro.class);
                MainActivity.this.startActivity(intentReg);


            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userET.getText().toString().equals("") || pwdET.getText().toString().equals("")){
                    Toast toast = Toast.makeText(MainActivity.this, "Rellene los campos", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(userET.getText().toString(), pwdET.getText().toString())
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(MainActivity.this, "Usuario y/o contraseña incorrectos",
                                                Toast.LENGTH_SHORT).show();
                                    }else{
                                        Intent intent = new Intent(MainActivity.this, Home.class);
                                        startActivity(intent);
                                        finish();

                                    }
                                }
                            });
                }
            }
        });
    }
}
