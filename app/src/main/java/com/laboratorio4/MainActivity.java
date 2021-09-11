package com.laboratorio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText IPnumber1;
    private EditText IPnumber2;
    private EditText IPnumber3;
    private EditText IPnumber4;

    private Button bnPing;
    private Button bnSearch;

    private TextView txtMyIP;

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

        bnPing.setOnClickListener(
                (v) -> {
                    Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, PingActivity.class);
                    startActivity(i);
                }
        );
    }
}