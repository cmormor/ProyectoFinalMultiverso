package com.cmormor.proyectofinalmultiverso;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View rootView = findViewById(android.R.id.content);

        Animation zoomInUp = AnimationUtils.loadAnimation(this, R.anim.zoom_center_fade);
        rootView.startAnimation(zoomInUp);
        Button btnIrLogin = findViewById(R.id.btnIrLogin);
        TextView contact = findViewById(R.id.contact);

        btnIrLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, Login.class);
                startActivity(intent);
            }
        });

        contact.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:622733671"));
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