package com.cmormor.proyectofinalmultiverso;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private static final String USERNAME_CORRECT = "admin";
    private static final String PASSWORD_CORRECT = "admin";

    private EditText etUser;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);

        TextView textView = findViewById(R.id.textView2);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        etUser.setTextColor(Color.parseColor("#FFFFFF"));
        etPassword.setTextColor(Color.parseColor("#FFFFFF"));

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = etUser.getText().toString().trim();
                String pass = etPassword.getText().toString().trim();

                if (user.equals(USERNAME_CORRECT) && pass.equals(PASSWORD_CORRECT)) {
                    Toast.makeText(Login.this, "Login exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Login.this, "Contraseña o usuario incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        TextView register = findViewById(R.id.textView2);
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rote);
        register.startAnimation(rotateAnimation);

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
