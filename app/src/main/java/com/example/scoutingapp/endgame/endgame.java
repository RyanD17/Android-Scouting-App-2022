package com.example.scoutingapp.endgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.example.scoutingapp.R;
import com.example.scoutingapp.autoscreen.MainActivity;
import com.example.scoutingapp.qr_code;
import com.example.scoutingapp.teleop_screen.teleop;


public class endgame extends MainActivity {

    SharedPreferences sp;
    //initializing toggle buttons
    public ToggleButton noneBtn, attempt, success, lowRung, midRung, highRung, transversalRung, slow, medium, fast;

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
        slow = findViewById(R.id.climb_slow);

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
            if (none_Clicked){
                noneBtn.setBackgroundColor(Color.GREEN);
                attempt.setBackgroundColor(Color.RED);
                success.setBackgroundColor(Color.RED);
            }
            else {
                noneBtn.setBackgroundColor(Color.RED);
            }
        });
    }

    public void attemptBtn_isPressed () {
        attempt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                if (attempt_isClicked){
                    attempt_isClicked = true;
                    noneBtn.setBackgroundColor(Color.RED);
                    attempt.setBackgroundColor(Color.GREEN);
                    success.setBackgroundColor(Color.RED);
                }
                else{
                    attempt_isClicked = false;
                    attempt.setBackgroundColor(Color.RED);
                }
            }
        });
    }
    public void successBtn_isPressed () {
        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                if (success_Clicked) {
                    success_Clicked=true;
                    noneBtn.setBackgroundColor(Color.RED);
                    attempt.setBackgroundColor(Color.RED);
                    success.setBackgroundColor(Color.GREEN);
                }
                else{
                    success_Clicked = false;
                    success.setBackgroundColor(Color.RED);
                }
            }
        });
    }

    public void lowRung_isPressed () {
        lowRung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                if (lowRung_isClicked) {
                    lowRung_isClicked = true;
                    lowRung.setBackgroundColor(Color.GREEN);
                    midRung.setBackgroundColor(Color.RED);
                    highRung.setBackgroundColor(Color.RED);
                    transversalRung.setBackgroundColor(Color.RED);
                } else {
                    lowRung_isClicked = false;
                    lowRung.setBackgroundColor(Color.RED);
                }
            }
        });
    }

    public void midRung_isPressed () {
        midRung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                if (medium_isClicked) {
                    midRung_isClicked  = true;
                    midRung.setBackgroundColor(Color.GREEN);
                    lowRung.setBackgroundColor(Color.RED);
                    highRung.setBackgroundColor(Color.RED);
                    transversalRung.setBackgroundColor(Color.RED);
                } else {
                    midRung_isClicked = true;
                    midRung.setBackgroundColor(Color.RED);
                }
            }
        });
    }

    public void HighRung_isPressed () {
        highRung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                if (highRung_isClicked) {
                    highRung_isClicked = true;
                    highRung.setBackgroundColor(Color.RED);
                    midRung.setBackgroundColor(Color.RED);
                    lowRung.setBackgroundColor(Color.GREEN);
                    transversalRung.setBackgroundColor(Color.RED);
                } else {
                    highRung_isClicked = false;
                    highRung.setBackgroundColor(Color.RED);
                }
            }
        });
    }

    public void transversalRung_IsPressed () {
        transversalRung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                if (taversal_isClicked) {
                    taversal_isClicked = true;
                    transversalRung.setBackgroundColor(Color.RED);
                    highRung.setBackgroundColor(Color.RED);
                    midRung.setBackgroundColor(Color.RED);
                    lowRung.setBackgroundColor(Color.GREEN);
                } else {
                    taversal_isClicked = false;
                    transversalRung.setBackgroundColor(Color.RED);
                }
            }
        });
    }
}