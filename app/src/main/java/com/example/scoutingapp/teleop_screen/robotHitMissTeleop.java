package com.example.scoutingapp.teleop_screen;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.scoutingapp.R;
import com.example.scoutingapp.autoscreen.MainActivity;

import java.util.Stack;

public class robotHitMissTeleop extends teleop {

    public Stack<Integer> stk = new Stack<>();

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_screen);
    }

    public void undoOperationTeleop() {
        switch (stk.firstElement()) {
            case 1:
                stk.push(LowMissCount);
                while (stk.firstElement() == LowMissCount) {
                    LowMissTxt.setText(Integer.toString(LowMissCount-=1));
                }
                stk.pop();
            case 3:
                stk.push(HighMissCount);
                while (stk.firstElement() == HighMissCount) {
                    HighMissBtnCount.setText(Integer.toString(HighMissCount-=1));
                }
                stk.pop();
            case 4:
                stk.push(LowHitCount);
                while (stk.firstElement() == LowHitCount) {
                    LowHitTxt.setText(Integer.toString(LowHitCount-=1));
                }
                stk.pop();
            case 5:
                Stack<Integer> stk=new Stack<>();
                stk.push(HighHitCount);
                while (stk.firstElement() == HighHitCount) {
                    HighHitBtnCount.setText(Integer.toString(HighHitCount-=1));
                }
                stk.pop();
        }
    }
    public void LowMiss_isPressed () {
        //code for making the  low miss button work
        LowMissBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                LowMiss_isClicked=true;
                LowMissTxt.setText(Integer.toString(LowMissCount++));

                undoButton.setOnClickListener(v1 -> undoOperationTeleop());
            }
        });
    }
    @SuppressLint("SetTextI18n")
    public void HighMiss_isPressed () {
        //code for making the  high miss button work
        HighMissBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                HighMiss_isClicked=true;
                HighMissBtnCount.setText(Integer.toString(HighMissCount++));
                undoButton.setOnClickListener(v1 -> undoOperationTeleop());
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void LowHit_isPressed () {
        //code for making the  low hit button work
        LowHitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                LowHit_isClicked=true;
                LowHitTxt.setText(Integer.toString(LowHitCount++));
                undoButton.setOnClickListener(v1 -> undoOperationTeleop());
            }
        });
    }
    public void HighHit_isPressed(){
        //code for making the  high hit button work
        HighHitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                HighHit_isClicked=true;
                HighHitBtnCount.setText(Integer.toString(HighHitCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick (View v) {
                        undoOperationTeleop();
                    }
                });
            }
        });
    }
}

