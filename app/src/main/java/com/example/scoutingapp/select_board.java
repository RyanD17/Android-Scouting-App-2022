package com.example.scoutingapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.scoutingapp.autoscreen.MainActivity;

public class select_board extends MainActivity {

    private CheckBox r1;
    private CheckBox r2;
    private CheckBox r3;

    private CheckBox b1;
    private CheckBox b2;
    private CheckBox b3;

    public boolean isR1Pressed = false;
    public boolean isR2Pressed = false;
    public boolean isR3Pressed = false;

    public boolean isB1Pressed = false;
    public boolean isB2Pressed = false;
    public boolean isB3Pressed = false;


    private final timer timerObj = new timer();


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_board);

        r1 = findViewById(R.id.red_1);
        r2 = findViewById(R.id.red_2);
        r3 = findViewById(R.id.red_3);

        r1 = findViewById(R.id.Blue_1);
        r1 = findViewById(R.id.blue_2);
        r1 = findViewById(R.id.blue_3);

        r1.setOnClickListener(v -> {
            Intent intent = new Intent(this,com.example.scoutingapp.select_board.class);
            startActivity(intent);
        });
    }
}