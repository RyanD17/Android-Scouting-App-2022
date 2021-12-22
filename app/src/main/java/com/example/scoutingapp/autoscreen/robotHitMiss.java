package com.example.scoutingapp.autoscreen;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.scoutingapp.R;

import java.util.Stack;

public class robotHitMiss extends MainActivity {
    Button autoHighMissBtn;
    TextView autoHighMissBtnCount;
    Button autoHighHitBtn;
    TextView autoHighHitBtnCount;
    Button autoLowMissBtn;
    TextView autoLowMissTxt;
    Button autoLowHitBtn;
    TextView autoLowHitTxt;

    Button HighMissBtn;
    TextView HighMissBtnCount;
    Button HighHitBtn;
    TextView HighHitBtnCount;
    Button LowMissBtn;
    TextView LowMissTxt;
    Button LowHitBtn;
    TextView LowHitTxt;


    public int autoHighMissCount = 0;
    public int autoHighHitCount = 0;
    public int autoLowMissCount = 0;
    public int autoLowHitCount = 0;

    public int HighMissCount = 0;
    public int HighHitCount = 0;
    public int LowMissCount = 0;
    public int LowHitCount = 0;

    public boolean autoHighHit_isClicked = false;
    public boolean autoHighMiss_isClicked = false;
    public boolean autoLowHit_isClicked = false;
    public boolean autoLowMiss_isClicked = false;

    public boolean HighHit_isClicked = false;
    public boolean LowHit_isClicked = false;
    public boolean HighMiss_isClicked = false;
    public boolean LowMiss_isClicked = false;

    @SuppressLint("CutPasteId")
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

        HighMissBtn = findViewById(R.id.autoHighMiss);
        HighMissBtnCount = findViewById(R.id.autoHighMissCount);
        HighHitBtn = findViewById(R.id.autoHighHit);
        HighHitBtnCount = findViewById(R.id.autoHighHitCount);
        LowMissBtn = findViewById(R.id.autoLowMiss);
        LowMissTxt = findViewById(R.id.autoLowMissCount);
        LowHitBtn = findViewById(R.id.autoLowHit);
        LowHitTxt = findViewById(R.id.autoLowHitCount);
    }

    public void autoHighHit_isPressed (){
        //code for making the auto high hit button work
        autoHighHitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                autoHighHit_isClicked = true;
                autoHighHitBtnCount.setText(Integer.toString(autoHighHitCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoHighHitUndoOperation();
                    }
                });
            }
        });
    }

    public void autoLowHit_isPressed (){
        //code for making the auto low hit button work
        autoLowHitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                autoLowHit_isClicked = true;
                autoLowHitTxt.setText(Integer.toString(autoLowHitCount++));

                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoLowHitUndoOperation();
                    }
                });
            }
        });
    }

    public void autoHighMiss_isPressed (){
        //code for making the auto high miss button work
        autoHighMissBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HighMiss_isClicked = true;
                autoHighMissBtnCount.setText(Integer.toString(autoHighMissCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoHighMissUndoOperation();
                    }
                });
            }
        });
    }

    public void autoLowMiss_isPressed(){
        //code for making the auto low miss button work
        autoLowMissBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                autoLowMiss_isClicked = true;
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
    public void HighHit_isPressed(){
        //code for making the  high hit button work
        HighHitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HighHit_isClicked = true;
                HighHitBtnCount.setText(Integer.toString(HighHitCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HighHitUndoOperation();
                    }
                });
            }
        });
    }

    public void LowHit_isPressed(){
        //code for making the  low hit button work
        LowHitBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                LowHit_isClicked = true;
                LowHitTxt.setText(Integer.toString(LowHitCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LowHitUndoOperation();
                    }
                });
            }
        });
    }

    public void HighMiss_isPressed(){
        //code for making the  high miss button work
        HighMissBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HighMiss_isClicked = true;
                HighMissBtnCount.setText(Integer.toString(HighMissCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HighMissUndoOperation();
                    }
                });
            }
        });
    }

    public void LowMiss_isPressed(){
        //code for making the  low miss button work
        LowMissBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LowMiss_isClicked = true;
                LowMissTxt.setText(Integer.toString(LowMissCount++));

                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LowMissUndoOperation();
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
    private void LowMissUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(LowMissCount);
        while (stk.firstElement() == LowMissCount) {
            LowMissTxt.setText(Integer.toString(LowMissCount -= 1));
        }
        stk.pop();
    }

    private void HighMissUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(HighMissCount);
        while (stk.firstElement() == HighMissCount) {
            HighMissBtnCount.setText(Integer.toString(HighMissCount -= 1));
        }
        stk.pop();
    }

    private void LowHitUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(LowHitCount);
        while (stk.firstElement() == LowHitCount) {
            LowHitTxt.setText(Integer.toString(LowHitCount -= 1));
        }
        stk.pop();
    }

    private void HighHitUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(HighHitCount);
        while (stk.firstElement() == HighHitCount) {
            HighHitBtnCount.setText(Integer.toString(HighHitCount -= 1));
        }
        stk.pop();
    }
}
