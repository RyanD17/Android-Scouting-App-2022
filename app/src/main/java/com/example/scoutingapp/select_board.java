package com.example.scoutingapp;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class select_board extends matchRow{

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    public Switch r1;
    public Switch r2;
    public Switch r3;

    public Switch b1;
    public Switch b2;
    public Switch b3;

    Button saveButton, okButton;

    public SharedPreferences sp;

    public boolean r1IsPressed = false;
    public boolean r2IsPressed = false;
    public boolean r3IsPressed = false;


    public boolean b1IsPressed = false;
    public boolean b2IsPressed = false;
    public boolean b3IsPressed = false;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_board);

        r1 = findViewById(R.id.board_R1);
        r2 = findViewById(R.id.board_R2);

        r3 = findViewById(R.id.board_r3);
        b1 = findViewById(R.id.board_b1);

        b2 = findViewById(R.id.board_b2);
        b3 = findViewById(R.id.board_b3);

        okButton = findViewById(R.id.ok_Button);
        saveButton = findViewById(R.id.save_Button);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                r1IsPressed = true;
                r2IsPressed = false;
                r3IsPressed = false;
                b1IsPressed = false;
                b2IsPressed = false;
                b3IsPressed = false;
            }
        });
        r1IsPressed = false;

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                r1IsPressed = false;
                r2IsPressed = true;
                r3IsPressed = false;
                b1IsPressed = false;
                b2IsPressed = false;
                b3IsPressed = false;
            }
        });
        r2IsPressed = false;

        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                r1IsPressed = false;
                r2IsPressed = false;
                r3IsPressed = true;
                b1IsPressed = false;
                b2IsPressed = false;
                b3IsPressed = false;
            }
        });
        r3IsPressed = false;

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                r1IsPressed = false;
                r2IsPressed = false;
                r3IsPressed = false;
                b1IsPressed = true;
                b2IsPressed = false;
                b3IsPressed = false;
            }
        });
        b1IsPressed = false;

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                r1IsPressed = false;
                r2IsPressed = false;
                r3IsPressed = false;
                b1IsPressed = false;
                b2IsPressed = true;
                b3IsPressed = false;
            }
        });
        b2IsPressed = false;

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                r1IsPressed = false;
                r2IsPressed = false;
                r3IsPressed = false;
                b1IsPressed = false;
                b2IsPressed = false;
                b3IsPressed = true;
            }
        });
        b3IsPressed = false;

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                SaveButton();
            }
        });
    }
    private void SaveButton () {
        SharedPreferences.Editor r1Editor = sp.edit();
        r1Editor.putString("Is Pressed", String.valueOf(r1IsPressed));
        r1Editor.apply();

        SharedPreferences.Editor r2Editor = sp.edit();
        r2Editor.putString("Is Pressed", String.valueOf(r2IsPressed));
        r2Editor.apply();


        SharedPreferences.Editor r3Editor = sp.edit();
        r3Editor.putString("Is Pressed", String.valueOf(r3IsPressed));
        r3Editor.apply();

        SharedPreferences.Editor B1Editor = sp.edit();
        B1Editor.putString("Is Pressed", String.valueOf(b1IsPressed));
        B1Editor.apply();

        SharedPreferences.Editor B2Editor = sp.edit();
        B2Editor.putString("Is Pressed", String.valueOf(b2IsPressed));
        B2Editor.apply();

        SharedPreferences.Editor B3Editor = sp.edit();
        B3Editor.putString("Is Pressed", String.valueOf(b3IsPressed));
        B3Editor.apply();
    }
}