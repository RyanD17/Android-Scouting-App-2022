package com.example.scoutingapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.autoscreen.MainActivity;
import com.example.scoutingapp.autoscreen.robotHitMiss;
import com.example.scoutingapp.endgame.endgame;
import com.example.scoutingapp.teleop_screen.defending;
import com.example.scoutingapp.teleop_screen.fouls;
import com.example.scoutingapp.teleop_screen.teleop;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
public class qr_code extends AppCompatActivity {

    ImageView qr_code;
    Button generateCode;

    public MainActivity mainActivityObj = new MainActivity();
    public robotHitMiss robotHitMissObj = new robotHitMiss();
    public defending defendingObj = new defending();
    public fouls foulsObj = new fouls();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        qr_code = findViewById(R.id.QRCode);
        generateCode = findViewById(R.id.generateCode);



        SharedPreferences sp;

        sp =  getSharedPreferences("My Shared Prefs", Context.MODE_PRIVATE);

        generateCode.setOnClickListener(v -> {
            SharedPreferences.Editor autoHighHitEditor = sp.edit();
            autoHighHitEditor.putString("number", String.valueOf(robotHitMissObj.autoHighHitCount));

            SharedPreferences.Editor autoLowHitEditor = sp.edit();
            autoLowHitEditor.putString("number", String.valueOf(robotHitMissObj.autoLowHitCount));

            SharedPreferences.Editor autoHighMissEditor = sp.edit();
            autoHighMissEditor.putString("number", String.valueOf(robotHitMissObj.autoHighMissCount));

            SharedPreferences.Editor autoLowMissEditor = sp.edit();
            autoLowMissEditor.putString("number", String.valueOf(robotHitMissObj.autoLowMissCount));

            SharedPreferences.Editor defenseTimeEditor = sp.edit();


        });

    }
}