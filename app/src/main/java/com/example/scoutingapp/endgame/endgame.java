package com.example.scoutingapp.endgame;

import android.graphics.Color;
import android.widget.CheckBox;
import android.widget.ToggleButton;

import com.example.scoutingapp.R;
import com.example.scoutingapp.autoscreen.MainActivity;


public class endgame extends MainActivity {

    //creating a new Main Activity Object
    public MainActivity mainActivityObj = new MainActivity();

    //initializing toggle buttons
    public ToggleButton noneBtn;
    public ToggleButton attempt;
    public ToggleButton success;
    public ToggleButton lowRung;
    public ToggleButton DSR_one;
    public ToggleButton DSR_three;
    public ToggleButton DSR_four;
    public ToggleButton DSR_five;

    //initializing check boxes
    public CheckBox balanced_cb;
    public CheckBox active_balanced_cb;

    public boolean isClicked = false;

    public endgame (float x1, float x2, float y1, float y2) {
        noneBtn = findViewById(R.id.climb_none);
        attempt = findViewById(R.id.climb_attempt);
        success = findViewById(R.id.climb_success);

        lowRung = findViewById(R.id.climb_mid);
        downBtn = findViewById(R.id.climb_high);
        middleBtn = findViewById(R.id.climb_low);
        balancedBtn = findViewById(R.id.climb_traversal);

        DSR_one = findViewById(R.id.one);
        DSR_two = findViewById(R.id.two);
        DSR_three = findViewById(R.id.three);
        DSR_four = findViewById(R.id.four);
        DSR_five = findViewById(R.id.five);

        balanced_cb = findViewById(R.id.balanced_cb);
        active_balanced_cb = findViewById(R.id.active_balance_cb);

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

    public void upBtn_isPressed () {
        if (isClicked) {
            upBtn.setBackgroundColor(Color.GREEN);
            downBtn.setBackgroundColor(Color.RED);
            middleBtn.setBackgroundColor(Color.RED);
            balancedBtn.setBackgroundColor(Color.RED);
        } else {
            upBtn.setBackgroundColor(Color.RED);
        }
    }

    public void downBtn_isPressed () {
        if (isClicked) {
            downBtn.setBackgroundColor(Color.GREEN);
            upBtn.setBackgroundColor(Color.RED);
            middleBtn.setBackgroundColor(Color.RED);
            balancedBtn.setBackgroundColor(Color.RED);
        } else {
            downBtn.setBackgroundColor(Color.RED);
        }
    }

    public void middleBtn_isPressed () {
        if (isClicked) {
            downBtn.setBackgroundColor(Color.RED);
            upBtn.setBackgroundColor(Color.RED);
            middleBtn.setBackgroundColor(Color.GREEN);
            balancedBtn.setBackgroundColor(Color.RED);
        } else {
            middleBtn.setBackgroundColor(Color.RED);
        }
    }

    public void balancedBtn_IsPressed () {
        if (isClicked) {
            downBtn.setBackgroundColor(Color.RED);
            upBtn.setBackgroundColor(Color.RED);
            middleBtn.setBackgroundColor(Color.RED);
            balancedBtn.setBackgroundColor(Color.GREEN);
        } else {
            balancedBtn.setBackgroundColor(Color.RED);
        }
    }
}
