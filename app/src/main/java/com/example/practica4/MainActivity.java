package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText tx1, tx2, tx3, tx4;
    private String c1, c2, c3, c4, laIp;
    private Button btPing, btHost;
    private Boolean conectado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar
        tx1 = findViewById(R.id.tx1);
        tx2 = findViewById(R.id.tx2);
        tx3 = findViewById(R.id.tx3);
        tx4 = findViewById(R.id.tx4);
        btPing = findViewById(R.id.btPing);
        btHost = findViewById(R.id.btHost);

        btPing.setOnClickListener(this);
        btHost.setOnClickListener(this);

       // 192.168.2.110


    }


    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case(R.id.btPing):

                //para traer lo que se escriba en la pantalla de la ip
                c1 = tx1.getText().toString();
                c2 = tx2.getText().toString();
                c3 = tx3.getText().toString();
                c4 = tx4.getText().toString();
                laIp = c1+"."+c2+"."+c3+"."+c4;

                Intent i = new Intent(this, pantallaping.class);

                i.putExtra("lasIp", laIp);

                startActivity(i);
                overridePendingTransition(R.anim.entrada, R.anim.salida);

                break;

            case(R.id.btHost):

                Intent a = new Intent(this, pantallahost.class);

                startActivity(a);
                overridePendingTransition(R.anim.entrada, R.anim.salida);

                break;
        }
    }
}