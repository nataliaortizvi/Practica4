package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText tx1, tx2, tx3, tx4;
    private Button btPing, btHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx1 = findViewById(R.id.tx1);
        tx2 = findViewById(R.id.tx2);
        tx3 = findViewById(R.id.tx3);
        tx4 = findViewById(R.id.tx4);
        btPing = findViewById(R.id.btPing);
        btHost = findViewById(R.id.btHost);

        btPing.setOnClickListener(this);
        btHost.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case(R.id.btPing):

                Intent i = new Intent(this, pantallaping.class);
                startActivity(i);
                overridePendingTransition(R.anim.entrada, R.anim.salida);

                break;

            case(R.id.btHost):

                Intent a = new Intent(this, pantallahost.class);
                startActivity(a);
                overridePendingTransition(R.anim.entrada2, R.anim.salida2);

                break;
        }
    }
}