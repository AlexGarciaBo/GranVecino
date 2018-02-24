package com.example.alberto.granvecino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Home extends AppCompatActivity {

    ListView lista;
    String [][] datos = {{"1","Favoritos"},
            {"2","Solicitar Voluntario"},
            {"3","Ofrecerse Voluntario"},
            {"4","Ver Anuncios"},
            {"5","Mi Perfil"}
    };
    int [] datosImg = {R.drawable.corazon,R.drawable.solicitar,R.drawable.ofrezer,R.drawable.anuncios,R.drawable.perfil};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lista=(ListView)findViewById(R.id.ivLista);
        lista.setAdapter(new Adaptador(this,datos,datosImg));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position ==0 ) {
                        Intent intentFav = new Intent(Home.this, Favoritos.class);
                    Home.this.startActivity(intentFav);
                }
                if (position == 1) {
                    Intent intentSol = new Intent(Home.this, Solicitar.class);
                    Home.this.startActivity(intentSol);
                }
                if (position == 2){
                    Intent intentOfr = new Intent(Home.this, Ofrecer.class);
                    Home.this.startActivity(intentOfr);
                }
                if (position == 3){
                    Intent intentTab = new Intent(Home.this, Tablon.class);
                    Home.this.startActivity(intentTab);
                }
                if (position ==4){
                    Intent intentPer = new Intent(Home.this, Perfil.class);
                }
            }
        });

    }
}
