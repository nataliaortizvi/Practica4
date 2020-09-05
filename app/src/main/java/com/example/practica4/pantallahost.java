package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class pantallahost extends AppCompatActivity {

    private Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallahost);

        btBack = findViewById(R.id.btBack);

        btBack.setOnClickListener(
                (view) -> {
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.entrada2, R.anim.salida2);

                }
        );
    }
}