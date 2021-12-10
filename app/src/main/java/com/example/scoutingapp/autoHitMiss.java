package com.example.scoutingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class autoHitMiss extends  MainActivity {
    Button autoHighMissBtn;
    TextView autoHighMissBtnCount;
    Button autoHighHitBtn;
    TextView autoHighHitBtnCount;
    Button autoLowMissBtn;
    TextView autoLowMissTxt;
    Button autoLowHitBtn;
    TextView autoLowHitTxt;

    public int autoHighMissCount = 0;
    public int autoHighHitCount = 0;
    public int autoLowMissCount = 0;
    public int autoLowHitCount = 0;

    public autoHitMiss autoHitMissObj = new autoHitMiss();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        autoHighMissBtn = findViewById(R.id.autoHighMiss);
        autoHighMissBtnCount = findViewById(R.id.autoHighMissCount);
        autoHighHitBtn = findViewById(R.id.autoHighHit);
        autoHighHitBtnCount = findViewById(R.id.autoHighHitCount);
        autoLowMissBtn = findViewById(R.id.autoLowMiss);
        autoLowMissTxt = findViewById(R.id.autoLowMissCount);
        autoLowHitBtn = findViewById(R.id.autoLowHit);
        autoLowHitTxt = findViewById(R.id.autoLowHitCount);

        //code for making the auto high hit button work
        autoHighHitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                autoHighHitBtnCount.setText(Integer.toString(autoHighHitCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoHighHitUndoOperation();
                    }
                });
            }
        });

        //code for making the auto low hit button work
        autoLowHitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                autoLowHitTxt.setText(Integer.toString(autoLowHitCount++));

                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoLowHitUndoOperation();
                    }
                });
            }
        });

        //code for making the auto high miss button work
        autoHighMissBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                autoHighMissBtnCount.setText(Integer.toString(autoHighMissCount++));

                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoHighMissUndoOperation();
                    }
                });
            }
        });

        //code for making the auto low miss button work
        autoLowMissBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                autoLowMissTxt.setText(Integer.toString(autoLowMissCount++));

                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoLowMissUndoOperation();
                    }
                });
            }
        });
    }

    private void autoLowMissUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(autoLowMissCount);
        while (stk.firstElement() == autoLowMissCount) {
            autoLowMissTxt.setText(Integer.toString(autoLowMissCount -= 1));
        }
        stk.pop();
    }

    private void autoHighMissUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(autoHighMissCount);
        while (stk.firstElement() == autoHighMissCount) {
            autoHighMissBtnCount.setText(Integer.toString(autoHighMissCount -= 1));
        }
        stk.pop();
    }

    private void autoLowHitUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(autoLowHitCount);
        while (stk.firstElement() == autoLowHitCount) {
            autoLowHitTxt.setText(Integer.toString(autoLowHitCount -= 1));
        }
        stk.pop();
    }

    private void autoHighHitUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(autoHighHitCount);
        while (stk.firstElement() == autoHighHitCount) {
            autoHighHitBtnCount.setText(Integer.toString(autoHighHitCount -= 1));
        }
        stk.pop();
    }
}
