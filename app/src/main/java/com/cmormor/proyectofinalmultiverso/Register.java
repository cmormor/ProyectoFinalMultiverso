package com.cmormor.proyectofinalmultiverso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    private EditText etEmail;
    private Button btnEnviar;
    private Button btnVolver;
    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.email);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnVolver = findViewById(R.id.btnVolver);
        tvMensaje = findViewById(R.id.tvMensaje);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();

                if (email.isEmpty()) {
                    Toast.makeText(Register.this, "Por favor, ingresa un email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!email.matches("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$")) {
                    Toast.makeText(Register.this, "Por favor, ingresa un email válido", Toast.LENGTH_SHORT).show();
                    return;
                }

                String mensaje = "<b>CREDENCIALES</b><br/>" +
                        "Usuario: " + USERNAME + "<br/>" +
                        "Contraseña: " + PASSWORD;
                tvMensaje.setText(android.text.Html.fromHtml(mensaje));

                Animation fadeIn = AnimationUtils.loadAnimation(Register.this, R.anim.fade_in);
                tvMensaje.startAnimation(fadeIn);
                tvMensaje.setVisibility(View.VISIBLE);

                Toast.makeText(Register.this, "Correo enviado", Toast.LENGTH_SHORT).show();
                btnVolver.startAnimation(fadeIn);
                btnVolver.setVisibility(View.VISIBLE);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
