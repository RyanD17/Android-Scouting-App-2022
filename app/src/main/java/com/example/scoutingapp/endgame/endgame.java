package com.example.scoutingapp.endgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ToggleButton;

import com.example.scoutingapp.R;
import com.example.scoutingapp.autoscreen.MainActivity;
import com.example.scoutingapp.qr_code;
import com.example.scoutingapp.teleop_screen.teleop;


public class endgame extends MainActivity {

    SharedPreferences sp;
    //initializing toggle buttons
    public ToggleButton noneBtn, attempt, success, lowRung, midRung, highRung, transversalRung;

    public Button goToQRCode, goToTeleop;
    public boolean taversal_isClicked = false;
    public boolean highRung_isClicked = false;
    public boolean midRung_isClicked = false;
    public boolean lowRung_isClicked = false;
    public boolean attempt_isClicked = false;
    public boolean none_Clicked = false;
    public boolean success_Clicked = false;
    public boolean slow_Clicked = false;
    public boolean medium_isClicked = false;
    public boolean fast_isClicked = false;




    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endgame_screen);

        noneBtn=findViewById(R.id.climb_none);
        attempt=findViewById(R.id.climb_attempt);
        success=findViewById(R.id.climb_success);

        midRung=findViewById(R.id.climb_mid);
        highRung=findViewById(R.id.climb_high);
        lowRung=findViewById(R.id.climb_low);
        transversalRung=findViewById(R.id.climb_traversal);
        goToTeleop = findViewById(R.id.goToTeleop);
        goToQRCode = findViewById(R.id.goToQRCode);

        sp=getSharedPreferences("My Shared Prefs", Context.MODE_PRIVATE);

        noneBtn_isPressed();
        attemptBtn_isPressed();
        successBtn_isPressed();
        lowRung_isPressed();
        midRung_isPressed();
        HighRung_isPressed();
        transversalRung_IsPressed();

        goToTeleop.setOnClickListener(v -> {
            Intent teleopIntent = new Intent(endgame.this, teleop.class);
            startActivity(teleopIntent);
        });

        goToQRCode.setOnClickListener(v ->{
            Intent goToQRCode = new Intent(this, qr_code.class);
            startActivity(goToQRCode);
        });
    }

    public void noneBtn_isPressed ()  {
        noneBtn.setOnClickListener(v -> {
            noneBtn.setBackgroundColor(Color.GREEN);
            attempt.setBackgroundColor(Color.RED);
            success.setBackgroundColor(Color.RED);
        });
        noneBtn.setBackgroundColor(Color.RED);
    }

    public void attemptBtn_isPressed () {
        if (attempt_isClicked) {
            noneBtn.setBackgroundColor(Color.RED);
            attempt.setBackgroundColor(Color.GREEN);
            success.setBackgroundColor(Color.RED);
        } else {
             attempt.setBackgroundColor(Color.RED);
        }
    }

    public void successBtn_isPressed () {
        if (success_Clicked) {
            noneBtn.setBackgroundColor(Color.RED);
            attempt.setBackgroundColor(Color.RED);
            success.setBackgroundColor(Color.GREEN);
        } else {
            success.setBackgroundColor(Color.RED);
        }
    }

    public void lowRung_isPressed () {
        if (lowRung_isClicked) {
            lowRung.setBackgroundColor(Color.GREEN);
            midRung.setBackgroundColor(Color.RED);
            highRung.setBackgroundColor(Color.RED);
            transversalRung.setBackgroundColor(Color.RED);
        } else {
            lowRung.setBackgroundColor(Color.RED);
        }
    }

    public void midRung_isPressed () {
        if (medium_isClicked) {
            midRung.setBackgroundColor(Color.GREEN);
            lowRung.setBackgroundColor(Color.RED);
            highRung.setBackgroundColor(Color.RED);
            transversalRung.setBackgroundColor(Color.RED);
        } else {
            midRung.setBackgroundColor(Color.RED);
        }
    }

    public void HighRung_isPressed () {
        if (highRung_isClicked) {
            highRung.setBackgroundColor(Color.RED);
            midRung.setBackgroundColor(Color.RED);
            lowRung.setBackgroundColor(Color.GREEN);
            transversalRung.setBackgroundColor(Color.RED);
        } else {
            highRung.setBackgroundColor(Color.RED);
        }
    }

    public void transversalRung_IsPressed () {
        if (taversal_isClicked) {
            transversalRung.setBackgroundColor(Color.RED);
            highRung.setBackgroundColor(Color.RED);
            midRung.setBackgroundColor(Color.RED);
            lowRung.setBackgroundColor(Color.GREEN);
        } else {
            transversalRung.setBackgroundColor(Color.RED);
        }
    }
}