package com.example.scoutingapp.endgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import com.example.scoutingapp.CommentActivity;
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
        medium = findViewById(R.id.climb_medum);
        fast = findViewById(R.id.fast_climb);

        goToTeleop = findViewById(R.id.goToTeleop);
        goToQRCode = findViewById(R.id.goToQRCode);
        ImageButton commentButton =findViewById(R.id.commentBtn);

        sp=getSharedPreferences("My Shared Prefs", Context.MODE_PRIVATE);

        noneBtn_isPressed();
        attemptBtn_isPressed();
        successBtn_isPressed();
        lowRung_isPressed();
        midRung_isPressed();
        HighRung_isPressed();
        transversalRung_IsPressed();
        slowClicked();
        mediumClicked();
        FastIsClicked();

        goToTeleop.setOnClickListener(v -> {
            Intent teleopIntent = new Intent(endgame.this, teleop.class);
            startActivity(teleopIntent);
        });

        goToQRCode.setOnClickListener(v ->{
            Intent goToQRCode = new Intent(this, qr_code.class);
            startActivity(goToQRCode);
        });
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent goToComment = new Intent(endgame.this, CommentActivity.class);
                startActivity(goToComment);
;            }
        });
    }

    public void noneBtn_isPressed ()  {
        noneBtn.setOnClickListener(v -> {
            none_Clicked = true;
            if (none_Clicked){
                noneBtn.setBackgroundColor(Color.GREEN);
                attempt.setBackgroundColor(Color.RED);
                success.setBackgroundColor(Color.RED);
            }
            else {
                none_Clicked = false;
                noneBtn.setBackgroundColor(Color.RED);
            }
        });
    }

    public void attemptBtn_isPressed () {
        attempt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                attempt_isClicked = true;
                if (attempt_isClicked){
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
                success_Clicked=true;
                if (success_Clicked) {
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
                lowRung_isClicked = true;
                if (lowRung_isClicked) {
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
                midRung_isClicked  = true;
                if (midRung_isClicked) {
                    midRung.setBackgroundColor(Color.GREEN);
                    lowRung.setBackgroundColor(Color.RED);
                    highRung.setBackgroundColor(Color.RED);
                    transversalRung.setBackgroundColor(Color.RED);
                } else {
                    midRung_isClicked = false;
                    midRung.setBackgroundColor(Color.RED);
                }
            }
        });
    }

    public void HighRung_isPressed () {
        highRung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                highRung_isClicked = true;
                if (highRung_isClicked) {
                    highRung.setBackgroundColor(Color.GREEN);
                    midRung.setBackgroundColor(Color.RED);
                    lowRung.setBackgroundColor(Color.RED);
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
                taversal_isClicked = true;
                if (taversal_isClicked) {
                    transversalRung.setBackgroundColor(Color.GREEN);
                    highRung.setBackgroundColor(Color.RED);
                    midRung.setBackgroundColor(Color.RED);
                    lowRung.setBackgroundColor(Color.RED);
                } else {
                    taversal_isClicked = false;
                    transversalRung.setBackgroundColor(Color.RED);
                }
            }
        });
    }
    public void slowClicked(){
        slow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                slow_Clicked = true;
                if (slow_Clicked){
                    slow.setBackgroundColor(Color.GREEN);
                    medium.setBackgroundColor(Color.RED);
                    fast.setBackgroundColor(Color.RED);
                }
                else {
                    slow_Clicked = false;
                    slow.setBackgroundColor(Color.RED);
                }
            }
        });
    }
    public void mediumClicked (){
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                medium_isClicked = true;
                if (medium_isClicked){
                    slow.setBackgroundColor(Color.RED);
                    medium.setBackgroundColor(Color.GREEN);
                    fast.setBackgroundColor(Color.RED);
                }
                else{
                    medium_isClicked = false;
                    medium.setBackgroundColor(Color.RED);
                }
            }
        });
    }
    public void FastIsClicked (){
        fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                fast_isClicked = true;
                if (fast_isClicked){
                    slow.setBackgroundColor(Color.RED);
                    slow_Clicked = false;

                    medium.setBackgroundColor(Color.RED);
                    medium_isClicked = false;

                    fast.setBackgroundColor(Color.GREEN);
                }
                else{
                    medium_isClicked = false;
                    medium.setBackgroundColor(Color.RED);
                }
            }
        });
    }
}