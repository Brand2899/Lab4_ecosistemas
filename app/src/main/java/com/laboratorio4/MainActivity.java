package com.laboratorio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private EditText IPnumber1;
    private EditText IPnumber2;
    private EditText IPnumber3;
    private EditText IPnumber4;

    private Button bnPing;
    private Button bnSearch;

    private TextView txtMyIP;
    private TextView txtIP;

    private String localIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IPnumber1 = findViewById(R.id.IPnumber1);
        IPnumber2 = findViewById(R.id.IPnumber2);
        IPnumber3 = findViewById(R.id.IPnumber3);
        IPnumber4 = findViewById(R.id.IPnumber4);

        bnPing = findViewById(R.id.bnPing);
        bnSearch = findViewById(R.id.bnSearch);

        txtMyIP = findViewById(R.id.txtMyIP);
        txtIP = findViewById(R.id.txtIP);

        //Gracias a : https://www.geeksforgeeks.org/how-to-fix-android-os-network-on-main-thread-exception-error-in-android-studio/

        Thread getIP = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    localIP = inetAddress.getHostAddress();
                    txtIP.setText(localIP);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        getIP.start();

        bnPing.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this, PingActivity.class);
                    startActivity(i);
                }
        );
    }
}