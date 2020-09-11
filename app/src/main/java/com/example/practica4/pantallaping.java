package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class pantallaping extends AppCompatActivity {

    private Button btBack;
    private TextView confirmacion, confirmacion2, confirmacion3, confirmacion4;
    private boolean conectado;
    private int maximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallaping);

        btBack = findViewById(R.id.btBack);
        confirmacion = findViewById(R.id.confirmacion);
        confirmacion2 = findViewById(R.id.confirmacion2);
        confirmacion3 = findViewById(R.id.confirmacion3);
        confirmacion4 = findViewById(R.id.confirmacion4);

        maximo = 0;

        String lasIp = getIntent().getExtras().getString("lasIp");

        new Thread(
                () -> {
                    while(maximo < 4){
                        try {
                            maximo ++;
                            InetAddress inetAddress = InetAddress.getByName(lasIp);
                            String ipEscrita = inetAddress.getHostAddress();
                            Log.d("celcho",""+ipEscrita);

                            conectado = inetAddress.isReachable(500);
                            Log.d("conectado",""+ conectado);

                            runOnUiThread(
                                    ()->{
                                        if(conectado == true){
                                            confirmacion.append("Recibido \n");
                                        }else{
                                            confirmacion.append("Perdido \n");
                                        }

                                    }
                            );

                            Thread.sleep(2000);

                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

        ).start();


        btBack.setOnClickListener(
                (view) -> {
                    Intent i = new Intent(this, MainActivity.class);
                    maximo = 5;
                    startActivity(i);
                    overridePendingTransition(R.anim.entrada2, R.anim.salida2);

                }
        );


    }

}