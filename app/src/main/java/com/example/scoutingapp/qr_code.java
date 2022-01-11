package com.example.scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.scoutingapp.autoscreen.MainActivity;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidmads.library.qrgenearator.QRGSaver;


public class qr_code extends AppCompatActivity {

    ImageView qr_code;
    Button generateCode;

    public MainActivity mainActivityObj = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        qr_code = findViewById(R.id.QRCode);
        generateCode = findViewById(R.id.generateCode);


        generateCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }
}