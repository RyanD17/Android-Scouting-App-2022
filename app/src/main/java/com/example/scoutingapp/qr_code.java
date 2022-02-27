package com.example.scoutingapp;

import android.annotation.SuppressLint;
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

    public final MainActivity mainActivityObj = new MainActivity();
    public final robotHitMiss robotHitMissObj = new robotHitMiss();
    public defending defendingObj = new defending();
    public final fouls foulsObj = new fouls();
    public final select_board select_boardObj = new select_board();

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

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor autoHighMissEditor = sp.edit();
            autoHighMissEditor.putString("number", String.valueOf(robotHitMissObj.autoHighMissCount));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor autoLowMissEditor = sp.edit();
            autoLowMissEditor.putString("number", String.valueOf(robotHitMissObj.autoLowMissCount));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor defenseTimeEditor = sp.edit();
            defenseTimeEditor.putString("number", String.valueOf(defendingObj.defense_count));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor foulsEditor = sp.edit();
            foulsEditor.putString("number", String.valueOf(foulsObj.foul_count));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor tech_foulEditor = sp.edit();
            tech_foulEditor.putString("number", String.valueOf(foulsObj.tech_foul_count));


        });
    }
}