package com.example.alberto.granvecino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ofrecer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofrecer);

        Button ofrecer=(Button)findViewById(R.id.ofrecerBTN);
        EditText descr=(EditText)findViewById(R.id.descET);
        EditText trabajo=(EditText)findViewById(R.id.trabajoET);

    }
}
