package com.laboratorio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PingActivity extends AppCompatActivity {

    private TextView txtP1;
    private TextView txtP2;
    private TextView txtP3;
    private TextView txtP4;
    private TextView txtP5;

    private Button bnBack;

    private String recivedIP;

    private boolean isReached = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping);

        recivedIP = getIntent().getExtras().getString("searchedIP");

        txtP1 = findViewById(R.id.txtP1);
        txtP2 = findViewById(R.id.txtP2);
        txtP3 = findViewById(R.id.txtP3);
        txtP4 = findViewById(R.id.txtP4);
        txtP5 = findViewById(R.id.txtP5);

        bnBack = findViewById(R.id.bnBack);

        Thread detectIP = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InetAddress inetAddress = InetAddress.getByName(recivedIP);

                    if(inetAddress.isReachable(300)){
                        txtP1.setText("Recibido");
                    }
                    else{
                        txtP1.setText("Perdido");
                    }


                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        detectIP.start();



        bnBack.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                }
        );
    }
}