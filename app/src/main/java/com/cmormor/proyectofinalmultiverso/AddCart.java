package com.cmormor.proyectofinalmultiverso;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cart);

        TextView homeIcon = findViewById(R.id.homeIcon);
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCart.this, Home.class);
                startActivity(intent);
            }
        });

        LinearLayout layoutCarrito = findViewById(R.id.layoutCarrito);
        TextView totalPrecio = findViewById(R.id.totalPrecio);
        Button btnVolver = findViewById(R.id.btnVolver);
        Button btnPagar = findViewById(R.id.btnPagar);

        for (ItemCart item : Cart.obtenerCarrito()) {
            LinearLayout itemLayout = new LinearLayout(this);
            itemLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams itemLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            itemLayoutParams.setMargins(0, 0, 0, 80);
            itemLayout.setLayoutParams(itemLayoutParams);

            TextView titleView = new TextView(this);
            titleView.setText(item.getTitulo());
            titleView.setTextColor(0xFFFFA3F3);
            titleView.setTextSize(18);
            LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            titleParams.setMargins(100, 0, 0, 0);
            titleView.setLayoutParams(titleParams);

            TextView priceView = new TextView(this);
            priceView.setText(String.format("%.2f€", item.getPrecio()));
            priceView.setTextColor(0xFFFFA3F3);
            priceView.setTextSize(18);
            priceView.setGravity(Gravity.END);
            priceView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            TextView removeButton = new TextView(this);
            removeButton.setText("X");
            removeButton.setTextSize(20);
            removeButton.setTextColor(0xFF808080);
            removeButton.setPadding(20, 5, 10, 5);
            removeButton.setOnClickListener(v -> {
                Cart.eliminarItem(item);
                layoutCarrito.removeView(itemLayout);
                totalPrecio.setText("TOTAL: " + String.format("%.2f€", Cart.calcularTotal()));
                btnPagar.setEnabled(!Cart.obtenerCarrito().isEmpty());
            });

            itemLayout.addView(titleView);
            itemLayout.addView(priceView);
            itemLayout.addView(removeButton);

            layoutCarrito.addView(itemLayout);
        }

        totalPrecio.setText("TOTAL: " + String.format("%.2f€", Cart.calcularTotal()));

        btnPagar.setEnabled(!Cart.obtenerCarrito().isEmpty());
        if (Cart.obtenerCarrito().isEmpty()) {
            btnPagar.setBackgroundColor(0xFF780B6F);
        }

        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(AddCart.this, Home.class);
            startActivity(intent);
        });

        btnPagar.setOnClickListener(v -> {
            Cart.vaciarCarrito();
            Intent intent = new Intent(AddCart.this, Confirmed.class);
            startActivity(intent);
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