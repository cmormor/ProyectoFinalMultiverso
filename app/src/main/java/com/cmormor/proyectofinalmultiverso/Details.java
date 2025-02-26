package com.cmormor.proyectofinalmultiverso;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        String titulo = intent.getStringExtra("titulo");
        int imagenResId = intent.getIntExtra("imagenResId", 0);
        String descripcion = intent.getStringExtra("descripcion");
        double precio = intent.getDoubleExtra("precio", 0.0);

        ImageView comicImagen = findViewById(R.id.comicImagen);
        TextView comicTitulo = findViewById(R.id.comicTitulo);
        TextView comicDescripcion = findViewById(R.id.comicDescripcion);
        TextView comicPrecio = findViewById(R.id.comicPrecio);
        Button btnAgregarCarrito = findViewById(R.id.btnAgregarCarrito);

        comicImagen.setImageResource(imagenResId);
        comicTitulo.setText(titulo);
        comicDescripcion.setText(descripcion);
        comicPrecio.setText(String.format("%.2f€", precio));

        Button btnVolverHome = findViewById(R.id.btnVolverHome);
        btnVolverHome.setOnClickListener(v -> {
            Intent intentHome = new Intent(Details.this, Home.class);
            intentHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intentHome);
        });

        btnAgregarCarrito.setOnClickListener(v -> {
            ItemCart item = new ItemCart(titulo, precio);
            Cart.agregarAlCarrito(item);
            Toast.makeText(Details.this, titulo + " agregado al carrito", Toast.LENGTH_SHORT).show();
        });



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