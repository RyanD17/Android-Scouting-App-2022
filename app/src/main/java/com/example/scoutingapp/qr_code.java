package com.example.scoutingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.autoscreen.robotHitMiss;
import com.example.scoutingapp.endgame.endgame;
import com.example.scoutingapp.teleop_screen.defending;
import com.example.scoutingapp.teleop_screen.fouls;

public class qr_code extends AppCompatActivity {

    Button generateQRCode;
    public final robotHitMiss robotHitMissObj = new robotHitMiss();
    public defending defendingObj = new defending();
    public final fouls foulsObj = new fouls();
    public final select_board select_boardObj = new select_board();
    public final CommentActivity commentActivityObj = new CommentActivity();
    public endgame endgameObj = new endgame();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        generateQRCode = findViewById(R.id.generateQR);


        SharedPreferences sp;

        sp=getSharedPreferences("My Shared Prefs", Context.MODE_PRIVATE);

        generateQRCode.setOnClickListener(v -> {

            SharedPreferences.Editor robotDisabledEditor = sp.edit();
            SharedPreferences.Editor robotIncapacitatedEditor = sp.edit();
            SharedPreferences.Editor entryStaredLateEditor = sp.edit();
            SharedPreferences.Editor reScoutRequiredEditor = sp.edit();



            SharedPreferences.Editor autoHighHitEditor=sp.edit();
            autoHighHitEditor.putString("number", String.valueOf(robotHitMissObj.autoHighHitCount));

            SharedPreferences.Editor autoLowHitEditor=sp.edit();
            autoLowHitEditor.putString("number", String.valueOf(robotHitMissObj.autoLowHitCount));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor autoHighMissEditor=sp.edit();
            autoHighMissEditor.putString("number", String.valueOf(robotHitMissObj.autoHighMissCount));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor autoLowMissEditor=sp.edit();
            autoLowMissEditor.putString("number", String.valueOf(robotHitMissObj.autoLowMissCount));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor defenseTimeEditor=sp.edit();
            defenseTimeEditor.putString("number", String.valueOf(defendingObj.defense_count));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor foulsEditor=sp.edit();
            foulsEditor.putString("number", String.valueOf(foulsObj.foul_count));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor tech_foulEditor=sp.edit();
            tech_foulEditor.putString("number", String.valueOf(foulsObj.tech_foul_count));

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


            endgameObj.transversalEditor.putString("is Pressed", String.valueOf(endgameObj.taversal_isClicked));
            endgameObj.highRungEditor.putString("Is Pressed", String.valueOf(endgameObj.highRung_isClicked));
            endgameObj.midRungEditor.putString("Is Pressed", String.valueOf(endgameObj.midRung_isClicked));
            endgameObj.lowRungEditor.putString("Is Pressed", String.valueOf(endgameObj.lowRung_isClicked));

            endgameObj.attemptEditor.putString("Is Pressed", String.valueOf(endgameObj.attempt_isClicked));
            endgameObj.noneEditor.putString("Is Pressed", String.valueOf(endgameObj.none_Clicked));
            endgameObj.successEditor.putString("Is Pressed", String.valueOf(endgameObj.success_Clicked));

            endgameObj.slowEditor.putString("Is Pressed", String.valueOf(endgameObj.slow_Clicked));
            endgameObj.mediumEditor.putString("Is Pressed", String.valueOf(endgameObj.medium_isClicked));
            endgameObj.fastEditor.putString("Is Pressed", String.valueOf(endgameObj.fast_isClicked));



        });
    }
}