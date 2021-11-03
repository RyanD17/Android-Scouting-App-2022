package com.example.scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    //initializing variables
    Button allianceTrenchBtn = findViewById(R.id.alliance_trench);
    TextView allianceTrenchBtnCount = findViewById(R.id.AllianceTrenchCount);
    Button rendezvousBtn = findViewById(R.id.rendezvous);
    TextView rendezvousBtnCount = findViewById(R.id.RendezvousCount);
    Button opponentTrenchBtn = findViewById(R.id.opponentTrench);
    TextView opponentTrenchCount = findViewById(R.id.OppTrenchCount);
    Button autoHighMissBtn = findViewById(R.id.autoHighMiss);
    TextView autoHighMissBtnCount = findViewById(R.id.autoHighMissCount);
    Button autoHighHitBtn = findViewById(R.id.AutoHighHit);
    TextView autoHighHitBtnCount = findViewById(R.id.autoHighHitCount);
    Button autoLowMissBtn = findViewById(R.id.autoLowMiss);
    TextView autoLowMissCount = findViewById(R.id.autoLowMissCount);
    Button autoLowHitBtn = findViewById(R.id.AutoLowHit);
    TextView autoLowHitCount = findViewById(R.id.autoLowHitCount);
    ToggleButton crossBtn = findViewById(R.id.crossBtn);
    ToggleButton trenchBtn = findViewById(R.id.trenchBtn);
    ToggleButton midBtn = findViewById(R.id.midBtn);
    ToggleButton targetBtn = findViewById(R.id.targetBtn);
     ProgressBar matchTimer = findViewById(R.id.matchTimer);

    public boolean isClicked = false;
    public  boolean isTimerRunning = false;
    public long startTimeInMilliseconds = 165000;
    public long timeLeftInMilliseconds = 165000;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        matchTimer.setMax(165);
        matchTimer.setProgress(0);


        //code for making the alliance trench button work
        allianceTrenchBtn.setOnClickListener(new View.OnClickListener() { //I call the onClickListener function
            int count = 0;
            public void onClick(View v) {//if the alliance trench button is clicked, then this executes
                allianceTrenchBtnCount.setText(Integer.toString(count++));
            }
        });

        //code for making the rendezvous button work
        rendezvousBtn.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            public void onClick(View v) {
                rendezvousBtnCount.setText(Integer.toString(count ++));
            }
        });

        //code for making the opponent trench button work
        opponentTrenchBtn.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            public void onClick(View v) {
                opponentTrenchCount.setText(Integer.toString(count++));
            }
        });

        //code for making the auto high hit button work
        autoHighHitBtn.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            public void onClick(View v) {
                autoHighHitBtnCount.setText(Integer.toString(count++));
            }
        });

        //code for making the auto low hit button work
        autoLowHitBtn.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            public void onClick(View v) {
                autoLowHitCount.setText(Integer.toString(count++));
            }
        });

        //code for making the auto high miss button work
        autoHighMissBtn.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            public void onClick(View v) {
                autoHighMissBtnCount.setText(Integer.toString(count++));
            }
        });

        //code for making the auto low miss button work
        autoLowMissBtn.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            public void onClick(View v) {
                autoLowMissCount.setText(Integer.toString(count++));
            }
        });

        crossBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked){
                    crossBtn.setBackgroundColor(Color.GREEN);
                }
                else{
                    crossBtn.setBackgroundColor(Color.RED);
                }
            }
        });

        trenchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked){
                    trenchBtn.setBackgroundColor(Color.GREEN);
                }
                else{
                    trenchBtn.setBackgroundColor(Color.RED);
                }
            }
        });

        //code for making the mid button work
        midBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked){
                    //isClicked = true;
                    midBtn.setBackgroundColor(Color.GREEN);
                }
                else{
                    //isClicked = false;
                    midBtn.setBackgroundColor(Color.RED);
                }
            }
        });

        targetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked){
                    targetBtn.setBackgroundColor(Color.GREEN);
                }
                else{
                    targetBtn.setBackgroundColor(Color.RED);
                }
            }
        });
    }
}