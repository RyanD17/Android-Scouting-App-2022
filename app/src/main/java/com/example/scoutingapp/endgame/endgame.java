package com.example.scoutingapp.endgame;

import android.content.Intent;
import android.graphics.Color;
import android.view.MotionEvent;
import android.widget.CheckBox;
import android.widget.ToggleButton;

import com.example.scoutingapp.R;
import com.example.scoutingapp.autoscreen.MainActivity;
import com.example.scoutingapp.qr_code;
import com.example.scoutingapp.teleop_screen.teleop;


public class endgame extends MainActivity {

    //creating a new Main Activity Object
    public  MainActivity mainActivityObj=new MainActivity();
    //initializing toggle buttons
    public ToggleButton noneBtn, attempt, success, lowRung, midRung, highRung, transversalRung;
    //initializing check boxes
    public CheckBox balanced_cb, active_balanced_cb;

    public boolean isClicked=false;
    float x1, x2, y1, y2;

    public endgame () {

        noneBtn=findViewById(R.id.climb_none);
        attempt=findViewById(R.id.climb_attempt);
        success=findViewById(R.id.climb_success);

        midRung=findViewById(R.id.climb_mid);
        highRung=findViewById(R.id.climb_high);
        lowRung=findViewById(R.id.climb_low);
        transversalRung=findViewById(R.id.climb_traversal);
    }

    public void noneBtn_isPressed () {
        noneBtn.setOnClickListener(v -> {
            noneBtn.setBackgroundColor(Color.GREEN);
            attempt.setBackgroundColor(Color.RED);
            success.setBackgroundColor(Color.RED);
        });
        noneBtn.setBackgroundColor(Color.RED);
    }

    public void attemptBtn_isPressed () {
        if (isClicked) {
            noneBtn.setBackgroundColor(Color.RED);
            attempt.setBackgroundColor(Color.GREEN);
            success.setBackgroundColor(Color.RED);
        } else {
            attempt.setBackgroundColor(Color.RED);
        }
    }

    public void successBtn_isPressed () {
        if (isClicked) {
            noneBtn.setBackgroundColor(Color.RED);
            attempt.setBackgroundColor(Color.RED);
            success.setBackgroundColor(Color.GREEN);
        } else {
            success.setBackgroundColor(Color.RED);
        }
    }

    public void lowRung_isPressed () {
        if (isClicked) {
            lowRung.setBackgroundColor(Color.GREEN);
            midRung.setBackgroundColor(Color.RED);
            highRung.setBackgroundColor(Color.RED);
            transversalRung.setBackgroundColor(Color.RED);
        } else {
            lowRung.setBackgroundColor(Color.RED);
        }
    }

    public void midRung_isPressed () {
        if (isClicked) {
            midRung.setBackgroundColor(Color.GREEN);
            lowRung.setBackgroundColor(Color.RED);
            highRung.setBackgroundColor(Color.RED);
            transversalRung.setBackgroundColor(Color.RED);
        } else {
            midRung.setBackgroundColor(Color.RED);
        }
    }

    public void HighRung_isPressed () {
        if (isClicked) {
            highRung.setBackgroundColor(Color.RED);
            midRung.setBackgroundColor(Color.RED);
            lowRung.setBackgroundColor(Color.GREEN);
            transversalRung.setBackgroundColor(Color.RED);
        } else {
            highRung.setBackgroundColor(Color.RED);
        }
    }

    public void transversalRung_IsPressed () {
        if (isClicked) {
            transversalRung.setBackgroundColor(Color.RED);
            highRung.setBackgroundColor(Color.RED);
            midRung.setBackgroundColor(Color.RED);
            lowRung.setBackgroundColor(Color.GREEN);
        } else {
            transversalRung.setBackgroundColor(Color.RED);
        }
    }
}
