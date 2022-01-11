package com.example.scoutingapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.example.scoutingapp.autoscreen.MainActivity;

public class fieldArea extends MainActivity {

    public ToggleButton crossBtn;
    public ToggleButton trenchBtn;
    public ToggleButton midBtn;
    public ToggleButton targetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        crossBtn = findViewById(R.id.launchPadBtn);
        trenchBtn = findViewById(R.id.tarmacBtn);
        midBtn = findViewById(R.id.midBtn);
        targetBtn = findViewById(R.id.targetBtn);
    }
    public void isCrossClicked (){
        crossBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    midBtn.setBackgroundColor(Color.RED);
                    trenchBtn.setBackgroundColor(Color.RED);
                    targetBtn.setBackgroundColor(Color.RED);
                    crossBtn.setBackgroundColor(Color.GREEN);
                }
        });
        crossBtn.setBackgroundColor(Color.RED);
    }
    public void isTrenchClicked(){
        trenchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                midBtn.setBackgroundColor(Color.RED);
                crossBtn.setBackgroundColor(Color.RED);
                targetBtn.setBackgroundColor(Color.RED);
                trenchBtn.setBackgroundColor(Color.GREEN);
            }
        });
        trenchBtn.setBackgroundColor(Color.RED);
    }
    public void isMidClicked (){
        //code for making the mid button work
        midBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    trenchBtn.setBackgroundColor(Color.RED);
                    crossBtn.setBackgroundColor(Color.RED);
                    targetBtn.setBackgroundColor(Color.RED);
                    midBtn.setBackgroundColor(Color.GREEN);
                }
        });
        midBtn.setBackgroundColor(Color.RED);
    }
    public void isTargetClicked(){
        targetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                midBtn.setBackgroundColor(Color.RED);
                trenchBtn.setBackgroundColor(Color.RED);
                crossBtn.setBackgroundColor(Color.RED);
                targetBtn.setBackgroundColor(Color.GREEN);
                }
        });
        targetBtn.setBackgroundColor(Color.RED);
    }
}
