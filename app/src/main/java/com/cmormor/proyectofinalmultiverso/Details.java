package com.cmormor.proyectofinalmultiverso;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {

    private ImageView ivComic;
    private TextView tvTitle, tvDescription, tvPrice;
    private Button btnAddToCart;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ivComic = findViewById(R.id.ivComic);
        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);
        tvPrice = findViewById(R.id.tvPrice);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        Comic comic = (Comic) getIntent().getSerializableExtra("comic");
        if (comic != null) {
            ivComic.setImageResource(comic.getImagenResId());
            tvTitle.setText(comic.getTitulo());
            tvDescription.setText(comic.getDescripcion());
            tvPrice.setText(String.format("$%.2f", comic.getPrecio()));
        }

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Details.this, "Añadido al carrito", Toast.LENGTH_SHORT).show();
            }
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