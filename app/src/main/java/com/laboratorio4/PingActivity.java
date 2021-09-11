package com.laboratorio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PingActivity extends AppCompatActivity {

    private TextView txtP1;
    private TextView txtP2;
    private TextView txtP3;
    private TextView txtP4;
    private TextView txtP5;

    private Button bnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping);

        txtP1 = findViewById(R.id.txtP1);
        txtP2 = findViewById(R.id.txtP2);
        txtP3 = findViewById(R.id.txtP3);
        txtP4 = findViewById(R.id.txtP4);
        txtP5 = findViewById(R.id.txtP5);

        bnBack = findViewById(R.id.bnBack);

        bnBack.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                }
        );
    }
}