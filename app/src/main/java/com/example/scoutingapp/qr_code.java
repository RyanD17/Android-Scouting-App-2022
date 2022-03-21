package com.example.scoutingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.autoscreen.MainActivity;
import com.example.scoutingapp.endgame.endgame;
import com.example.scoutingapp.teleop_screen.teleop;
import com.google.zxing.qrcode.QRCodeWriter;

public class qr_code extends AppCompatActivity {

    Button generateQRCode, goToEndgame;
    public final MainActivity MainActivityObj = new MainActivity();
    public final teleop teleopObj = new teleop();
    public final select_board select_boardObj = new select_board();
    public final CommentActivity commentActivityObj = new CommentActivity();
    public endgame endgameObj = new endgame();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        generateQRCode = findViewById(R.id.generateQR);
        goToEndgame = findViewById(R.id.toEndgame);

        SharedPreferences sp;

        sp=getSharedPreferences("My Shared Prefs", Context.MODE_PRIVATE);

        goToEndgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent endgameIntent = new Intent(qr_code.this, endgame.class);
                startActivity(endgameIntent);
            }
        });

        generateQRCode.setOnClickListener(v -> {

            SharedPreferences.Editor robotDisabledEditor = sp.edit();
            SharedPreferences.Editor robotIncapacitatedEditor = sp.edit();
            SharedPreferences.Editor entryStaredLateEditor = sp.edit();
            SharedPreferences.Editor reScoutRequiredEditor = sp.edit();

            SharedPreferences.Editor transversalEditor = sp.edit();
            SharedPreferences.Editor highRungEditor = sp.edit();
            SharedPreferences.Editor midRungEditor = sp.edit();
            SharedPreferences.Editor lowRungEditor = sp.edit();

            SharedPreferences.Editor noneEditor = sp.edit();
            SharedPreferences.Editor attemptEditor = sp.edit();
            SharedPreferences.Editor successEditor = sp.edit();

            SharedPreferences.Editor slowEditor = sp.edit();
            SharedPreferences.Editor mediumEditor = sp.edit();
            SharedPreferences.Editor fastEditor = sp.edit();



            SharedPreferences.Editor autoHighHitEditor=sp.edit();
            autoHighHitEditor.putString("number", String.valueOf(MainActivityObj.autoHighHitCount));

            SharedPreferences.Editor autoLowHitEditor=sp.edit();
            autoLowHitEditor.putString("number", String.valueOf(MainActivityObj.autoLowHitCount));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor autoHighMissEditor=sp.edit();
            autoHighMissEditor.putString("number", String.valueOf(MainActivityObj.autoHighMissCount));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor autoLowMissEditor=sp.edit();
            autoLowMissEditor.putString("number", String.valueOf(MainActivityObj.autoLowMissCount));

            //@SuppressLint("CommitPrefEdits") SharedPreferences.Editor defenseTimeEditor=sp.edit();
            //defenseTimeEditor.putString("number", String.valueOf(teleopObj.defense_count));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor foulsEditor=sp.edit();
            foulsEditor.putString("number", String.valueOf(teleopObj.foul_count));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor tech_foulEditor=sp.edit();
            tech_foulEditor.putString("number", String.valueOf(teleopObj.tech_foul_count));

            SharedPreferences.Editor boardEditor=sp.edit();
            boardEditor.putString("r1", String.valueOf(select_boardObj.r1IsPressed));
            boardEditor.putString("r2", String.valueOf(select_boardObj.r2IsPressed));
            boardEditor.putString("r3", String.valueOf(select_boardObj.r3IsPressed));

            boardEditor.putString("b1", String.valueOf(select_boardObj.b1IsPressed));
            boardEditor.putString("b2", String.valueOf(select_boardObj.b2IsPressed));
            boardEditor.putString("b3", String.valueOf(select_boardObj.b3IsPressed));

            robotDisabledEditor.putString("is Pressed", String.valueOf(commentActivityObj.robot_disabled_isPressed));
            robotIncapacitatedEditor.putString("is Pressed", String.valueOf(commentActivityObj.robot_incapacitated_isPressed));
            entryStaredLateEditor.putString("is Pressed", String.valueOf(commentActivityObj.entry_isPressed));
            reScoutRequiredEditor.putString("is Pressed", String.valueOf(commentActivityObj.rescout_required_isPressed));


            transversalEditor.putString("is Pressed", String.valueOf(endgameObj.taversal_isClicked));
            highRungEditor.putString("Is Pressed", String.valueOf(endgameObj.highRung_isClicked));
            midRungEditor.putString("Is Pressed", String.valueOf(endgameObj.midRung_isClicked));
            lowRungEditor.putString("Is Pressed", String.valueOf(endgameObj.lowRung_isClicked));

            attemptEditor.putString("Is Pressed", String.valueOf(endgameObj.attempt_isClicked));
            noneEditor.putString("Is Pressed", String.valueOf(endgameObj.none_Clicked));
            successEditor.putString("Is Pressed", String.valueOf(endgameObj.success_Clicked));

            slowEditor.putString("Is Pressed", String.valueOf(endgameObj.slow_Clicked));
            mediumEditor.putString("Is Pressed", String.valueOf(endgameObj.medium_isClicked));
            fastEditor.putString("Is Pressed", String.valueOf(endgameObj.fast_isClicked));


            QRCodeWriter qrCodeWriter = new QRCodeWriter();

        });
    }
}