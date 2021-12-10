package com.example.scoutingapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class fieldAreaButtons extends MainActivity {
    ToggleButton crossBtn;
    ToggleButton trenchBtn;
    ToggleButton midBtn;
    ToggleButton targetBtn;

    public fieldAreaButtons fieldAreaButtonsObj = new fieldAreaButtons();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        crossBtn = findViewById(R.id.crossBtn);
        trenchBtn = findViewById(R.id.trenchBtn);
        midBtn = findViewById(R.id.midBtn);
        targetBtn = findViewById(R.id.targetBtn);

        crossBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    isClicked = true;
                    midBtn.setBackgroundColor(Color.RED);
                    trenchBtn.setBackgroundColor(Color.RED);
                    targetBtn.setBackgroundColor(Color.RED);
                    crossBtn.setBackgroundColor(Color.GREEN);
                } else {
                    isClicked = false;
                    crossBtn.setBackgroundColor(Color.RED);
                }
            }
        });

        trenchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    isClicked = true;
                    midBtn.setBackgroundColor(Color.RED);
                    crossBtn.setBackgroundColor(Color.RED);
                    targetBtn.setBackgroundColor(Color.RED);
                    trenchBtn.setBackgroundColor(Color.GREEN);
                } else {
                    isClicked = false;
                    trenchBtn.setBackgroundColor(Color.RED);
                }
            }
        });

        //code for making the mid button work
        midBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    isClicked = true;
                    trenchBtn.setBackgroundColor(Color.RED);
                    crossBtn.setBackgroundColor(Color.RED);
                    targetBtn.setBackgroundColor(Color.RED);
                    midBtn.setBackgroundColor(Color.GREEN);
                } else {
                    isClicked = false;
                    midBtn.setBackgroundColor(Color.RED);
                }
            }
        });

        targetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    isClicked = true;
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
