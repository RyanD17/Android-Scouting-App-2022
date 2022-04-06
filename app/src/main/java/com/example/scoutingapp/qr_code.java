package com.example.scoutingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.scoutingapp.endgame.endgame;



public class qr_code extends AppCompatActivity {

    Button goToEndgame;


    public qr_code() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        Button generateQrBtn = findViewById(R.id.generateQR);
        ImageView qrCodeIV=findViewById(R.id.qrCode);
        goToEndgame = findViewById(R.id.goToEndgame);


        goToEndgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent endgameIntent = new Intent(qr_code.this, endgame.class);
                startActivity(endgameIntent);
            }
        });

        generateQrBtn.setOnClickListener(v -> {

        });
    }
}