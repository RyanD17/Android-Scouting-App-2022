package com.example.scoutingapp.autoscreen;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.scoutingapp.R;

import java.util.Stack;

public class robotHitMiss extends MainActivity{

    public Stack<Integer> stk = new Stack<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);
    }
    public void autoHighHit_isPressed (){
        //code for making the auto high hit button work
        autoHighHitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                autoHighHit_isClicked = true;
                autoHighHitBtnCount.setText(Integer.toString(autoHighHitCount++));
                undoButton.setOnClickListener(v1 -> undoOperation());
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void autoLowHit_isPressed (){
        //code for making the auto low hit button work
        autoLowHitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                autoLowHit_isClicked = true;
                autoLowHitTxt.setText(Integer.toString(autoLowHitCount++));

                undoButton.setOnClickListener(v1 -> undoOperation());
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void autoHighMiss_isPressed (){
        //code for making the auto high miss button work
        autoHighMissBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                autoHighMiss_isClicked = true;
                autoHighMissBtnCount.setText(Integer.toString(autoHighMissCount++));
                undoButton.setOnClickListener(v1 -> undoOperation());
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void autoLowMiss_isPressed(){
        //code for making the auto low miss button work
        autoLowMissBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                autoLowMiss_isClicked = true;
                autoLowMissTxt.setText(Integer.toString(autoLowMissCount++));

                undoButton.setOnClickListener(v1 -> undoOperation());
            }
        });
    }

    public void undoOperation() {
        switch (stk.firstElement()) {
            case 1:
                stk.push(autoLowMissCount);
                while (stk.firstElement() == autoLowMissCount) {
                    autoLowMissTxt.setText(Integer.toString(autoLowMissCount-=1));
                }
                stk.pop();
            case 2:
                stk.push(autoHighMissCount);
                while (stk.firstElement() == autoHighMissCount) {
                    autoHighMissBtnCount.setText(Integer.toString(autoHighMissCount-=1));
                }
                stk.pop();
            case 3:
                stk.push(autoLowHitCount);
                while (stk.firstElement() == autoLowHitCount) {
                    autoLowHitTxt.setText(Integer.toString(autoLowHitCount-=1));
                }
                stk.pop();
            case 4:
                stk.push(autoHighHitCount);
                while (stk.firstElement() == autoHighHitCount) {
                    autoHighHitBtnCount.setText(Integer.toString(autoHighHitCount-=1));
                }
                stk.pop();
        }
    }
}
