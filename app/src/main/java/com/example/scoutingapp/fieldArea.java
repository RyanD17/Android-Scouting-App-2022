package com.example.scoutingapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.example.scoutingapp.R;
import com.example.scoutingapp.autoscreen.MainActivity;

public class fieldArea extends MainActivity {

    public ToggleButton crossBtn;
    public ToggleButton trenchBtn;
    public ToggleButton midBtn;
    public ToggleButton targetBtn;

    public boolean cross_isClicked = false;
    public boolean trench_isClicked = false;
    public boolean mid_isClicked = false;
    public boolean target_isClicked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        crossBtn = findViewById(R.id.crossBtn);
        trenchBtn = findViewById(R.id.trenchBtn);
        midBtn = findViewById(R.id.midBtn);
        targetBtn = findViewById(R.id.targetBtn);
    }
    public void isCrossClicked (){
        crossBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cross_isClicked) {
                    midBtn.setBackgroundColor(Color.RED);
                    trenchBtn.setBackgroundColor(Color.RED);
                    targetBtn.setBackgroundColor(Color.RED);
                    crossBtn.setBackgroundColor(Color.GREEN);
                } else {
                    cross_isClicked = false;
                    crossBtn.setBackgroundColor(Color.RED);
                }
            }
        });
    }
    public void isTrenchClicked(){
        trenchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (trench_isClicked) {
                    trench_isClicked = true;
                    midBtn.setBackgroundColor(Color.RED);
                    crossBtn.setBackgroundColor(Color.RED);
                    targetBtn.setBackgroundColor(Color.RED);
                    trenchBtn.setBackgroundColor(Color.GREEN);
                } else {
                    trench_isClicked = false;
                    trenchBtn.setBackgroundColor(Color.RED);
                }
            }
        });
    }
    public void isMidClicked (){
        //code for making the mid button work
        midBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mid_isClicked) {
                    mid_isClicked = true;
                    trenchBtn.setBackgroundColor(Color.RED);
                    crossBtn.setBackgroundColor(Color.RED);
                    targetBtn.setBackgroundColor(Color.RED);
                    midBtn.setBackgroundColor(Color.GREEN);
                } else {
                    mid_isClicked = false;
                    midBtn.setBackgroundColor(Color.RED);
                }
            }
        });
    }
    public void isTargetClicked(){
        targetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (target_isClicked) {
                    target_isClicked = true;
                    midBtn.setBackgroundColor(Color.RED);
                    trenchBtn.setBackgroundColor(Color.RED);
                    crossBtn.setBackgroundColor(Color.RED);
                    targetBtn.setBackgroundColor(Color.GREEN);
                } else {
                    targetBtn.setBackgroundColor(Color.RED);
                }
            }
        });
    }
}
