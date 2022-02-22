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

    public Stack<Integer> stk = new Stack<>();


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

    @SuppressLint("SetTextI18n")
    public void autoHighHit_isPressed (){
        //code for making the auto high hit button work
        autoHighHitBtn.setOnClickListener(v -> {
            autoHighHit_isClicked = true;
            autoHighHitBtnCount.setText(Integer.toString(autoHighHitCount++));
            undoButton.setOnClickListener(v1 -> undoOperation());
        });
    }

    @SuppressLint("SetTextI18n")
    public void autoLowHit_isPressed (){
        //code for making the auto low hit button work
        autoLowHitBtn.setOnClickListener(v -> {
            autoLowHit_isClicked = true;
            autoLowHitTxt.setText(Integer.toString(autoLowHitCount++));

            undoButton.setOnClickListener(v1 -> undoOperation());
        });
    }

    @SuppressLint("SetTextI18n")
    public void autoHighMiss_isPressed (){
        //code for making the auto high miss button work
        autoHighMissBtn.setOnClickListener(v -> {
            autoHighMiss_isClicked = true;
            autoHighMissBtnCount.setText(Integer.toString(autoHighMissCount++));
            undoButton.setOnClickListener(v1 -> undoOperation());
        });
    }

    @SuppressLint("SetTextI18n")
    public void autoLowMiss_isPressed(){
        //code for making the auto low miss button work
        autoLowMissBtn.setOnClickListener(v -> {
            autoLowMiss_isClicked = true;
            autoLowMissTxt.setText(Integer.toString(autoLowMissCount++));

            undoButton.setOnClickListener(v1 -> undoOperation());
        });
    }
    public void HighHit_isPressed(){
        //code for making the  high hit button work
        HighHitBtn.setOnClickListener(v -> {
            HighHit_isClicked = true;
            HighHitBtnCount.setText(Integer.toString(HighHitCount++));
            undoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    undoOperation();
                }
            });
        });
    }

    @SuppressLint("SetTextI18n")
    public void LowHit_isPressed(){
        //code for making the  low hit button work
        LowHitBtn.setOnClickListener(v -> {
            LowHit_isClicked = true;
            LowHitTxt.setText(Integer.toString(LowHitCount++));
            undoButton.setOnClickListener(v1 -> undoOperation());
        });
    }

    @SuppressLint("SetTextI18n")
    public void HighMiss_isPressed(){
        //code for making the  high miss button work
        HighMissBtn.setOnClickListener(v -> {
            HighMiss_isClicked = true;
            HighMissBtnCount.setText(Integer.toString(HighMissCount++));
            undoButton.setOnClickListener(v1 -> undoOperation());
        });
    }

    public void LowMiss_isPressed(){
        //code for making the  low miss button work
        LowMissBtn.setOnClickListener(v -> {
            LowMiss_isClicked = true;
            LowMissTxt.setText(Integer.toString(LowMissCount++));

            undoButton.setOnClickListener(v1 -> undoOperation());
        });
    }

    public void undoOperation(){
        switch (stk.firstElement()) {
            case 1:
                stk.push(autoLowMissCount);
                while (stk.firstElement() == autoLowMissCount){
                    autoLowMissTxt.setText(Integer.toString(autoLowMissCount-=1));
                }
                stk.pop();
            case 2:
                stk.push(autoHighMissCount);
                while (stk.firstElement() == autoHighMissCount) {
                    autoHighMissBtnCount.setText(Integer.toString(autoHighMissCount -= 1));
                }
                stk.pop();
            case 3:
                stk.push(autoLowHitCount);
                while (stk.firstElement() == autoLowHitCount) {
                    autoLowHitTxt.setText(Integer.toString(autoLowHitCount -= 1));
                }
                stk.pop();
            case 4:
                stk.push(autoHighHitCount);
                while (stk.firstElement() == autoHighHitCount) {
                    autoHighHitBtnCount.setText(Integer.toString(autoHighHitCount -= 1));
                }
                stk.pop();
            case 5:
                stk.push(LowMissCount);
                while (stk.firstElement() == LowMissCount) {
                    LowMissTxt.setText(Integer.toString(LowMissCount -= 1));
                }
                stk.pop();
            case 6:
                stk.push(HighMissCount);
                while (stk.firstElement() == HighMissCount) {
                    HighMissBtnCount.setText(Integer.toString(HighMissCount -= 1));
                }
                stk.pop();
            case 7:
                stk.push(LowHitCount);
                while (stk.firstElement() == LowHitCount) {
                    LowHitTxt.setText(Integer.toString(LowHitCount -= 1));
                }
                stk.pop();
            case 8:
                Stack<Integer> stk = new Stack<>();
                stk.push(HighHitCount);
                while (stk.firstElement() == HighHitCount) {
                    HighHitBtnCount.setText(Integer.toString(HighHitCount -= 1));
                }
                stk.pop();
        }
    }
}
