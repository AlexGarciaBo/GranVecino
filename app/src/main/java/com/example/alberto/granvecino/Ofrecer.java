package com.example.alberto.granvecino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Ofrecer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofrecer);

        Button ofrecer = (Button) findViewById(R.id.ofrecerBTN);
        EditText descr = (EditText) findViewById(R.id.descET);
        EditText trabajo = (EditText) findViewById(R.id.trabajoET);



    }
}

