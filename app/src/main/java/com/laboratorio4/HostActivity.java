package com.laboratorio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostActivity extends AppCompatActivity {

    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txt5;
    private TextView txt6;
    private TextView txt7;

    private Button bnBackHost;

    private String myIP;

    private String[] ip = new String[4];

    private int pos1;
    private int pos2;
    private int pos3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);

        bnBackHost = findViewById(R.id.bnBackHost);

        myIP = getIntent().getExtras().getString("myIP");
        ip = myIP.split(".");

        pos1 = Integer.parseInt(ip[0]);
        pos2 = Integer.parseInt(ip[1]);
        pos3 = Integer.parseInt(ip[2]);

        Thread isReachable = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i < 255; i++){
                    try {
                        InetAddress inetAddress = InetAddress.getByName("" + pos1 + "." + pos2 + "." + pos3 + "." + i);

                        if(inetAddress.isReachable(1000)){
                            if(i == 0){
                                txt1.setText(inetAddress.getHostName());
                            }
                            else if(i == 1){
                                txt2.setText(inetAddress.getHostName());
                            }
                            else if(i == 2){
                                txt3.setText(inetAddress.getHostName());
                            }
                            else if(i == 3){
                                txt4.setText(inetAddress.getHostName());
                            }
                            else if(i == 4){
                                txt5.setText(inetAddress.getHostName());
                            }
                            else if(i == 5){
                                txt6.setText(inetAddress.getHostName());
                            }
                            else if(i == 6){
                                txt7.setText(inetAddress.getHostName());
                            }
                        }

                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        bnBackHost.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                }
        );

    }
}