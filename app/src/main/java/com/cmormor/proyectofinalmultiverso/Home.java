package com.cmormor.proyectofinalmultiverso;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView cartIcon = findViewById(R.id.cartIcon);
        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, AddCart.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerViewComics);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Comic> listaComics = new ArrayList<>();
        listaComics.add(new Comic(
                "¡ PODER Y RESPONSABILIDAD !",
                R.drawable.spiderman1,
                "En este clásico, Peter Parker enfrenta las consecuencias de sus actos mientras asume la responsabilidad que conlleva ser Spider-Man.",
                12.99));
        listaComics.add(new Comic(
                "¡ SI ESTE ES MI DESTINO !",
                R.drawable.spiderman2,
                "Una aventura intensa en la que Spider-Man se ve forzado a elegir entre sus deberes heroicos y los sacrificios personales.",
                12.99));
        listaComics.add(new Comic(
                "¡ QUÉ VERDE ERA MI DUENDE !",
                R.drawable.spiderman3,
                "El legendario Duende Verde regresa con nuevos planes y conflictos, poniendo a prueba la determinación y el ingenio del héroe arácnido.",
                12.99));
        listaComics.add(new Comic(
                "¡ CRISIS EN EL CAMPUS !",
                R.drawable.spiderman4,
                "Cuando el caos estalla en su entorno universitario, Spider-Man se ve envuelto en una crisis que desafía sus límites y redefine su futuro.",
                12.99));

        ComicAdapter adapter = new ComicAdapter(this, listaComics);
        recyclerView.setAdapter(adapter);

        Log.d("CicloVida", "onCreate: La actividad se creó");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CicloVida", "onStart: La actividad está visible");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CicloVida", "onResume: La actividad está en primer plano (interactuable)");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CicloVida", "onPause: La actividad ya no está en primer plano");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CicloVida", "onStop: La actividad ya no es visible");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CicloVida", "onDestroy: La actividad se está destruyendo");
    }
}