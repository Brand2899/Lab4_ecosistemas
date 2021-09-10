package com.laboratorio4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PingReceptionActivity extends AppCompatActivity {

    private ConstraintLayout container;

    private TextView message1;
    private TextView message2;
    private TextView message3;
    private TextView message4;
    private TextView message5;

    private Button bnReturn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping_reception);

        container = findViewById(R.id.container);

        message1 = findViewById(R.id.message1);
        message2 = findViewById(R.id.message2);
        message3 = findViewById(R.id.message3);
        message4 = findViewById(R.id.message4);
        message5 = findViewById(R.id.message5);

        bnReturn = findViewById(R.id.bnSearch);

        bnReturn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                }
        );
    }
}