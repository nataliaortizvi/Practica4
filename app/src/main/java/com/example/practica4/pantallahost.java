package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class pantallahost extends AppCompatActivity {

    private Button btBack;
    private TextView validar;
    private int campo4 = 1;
    private String ipLocal;
    private Boolean conectado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallahost);

        btBack = findViewById(R.id.btBack);
        validar = findViewById(R.id.validar);


        new Thread(
                () -> {
                    while(campo4 < 255){

                        try {
                            //comprobacion y barrido de todas las id cambiando el ultimo digito
                            ipLocal = "192.168.2."+campo4;

                            InetAddress inetAddress = InetAddress.getByName(ipLocal);
                            String yoyo = inetAddress.getHostAddress();
                            Log.d("myHost",""+yoyo);

                            conectado = inetAddress.isReachable(500);
                            if(conectado == true){
                                validar.append(""+ipLocal+"\n");
                            }else{
                               //no hay
                            }

                            //para ir aumentando la cuarta variable del ip
                            campo4 ++;
                            Log.d("conectadoooooo",""+conectado);
                            Log.d("campoooooooo",""+campo4);


                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

        ).start();



        btBack.setOnClickListener(
                (view) -> {
                    //para parar el hilo
                    campo4 = 255;
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.entrada2, R.anim.salida2);

                }
        );
    }
}