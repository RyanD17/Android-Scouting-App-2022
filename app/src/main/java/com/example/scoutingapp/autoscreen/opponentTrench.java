package com.example.scoutingapp.autoscreen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.scoutingapp.R;

import java.util.Stack;

public class opponentTrench extends MainActivity {
    Button opponentTrenchBtn;
    TextView opponentTrenchCount;

    public int oppTrenchCount = 0;
    public boolean oppTrenchIsClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        opponentTrenchBtn = findViewById(R.id.opponentTrench);
        opponentTrenchCount = findViewById(R.id.OppTrenchCount);
    }
    public void oppTrench_IsPressed (){
        //code for making the opponent trench button work
        opponentTrenchBtn.setOnClickListener(new View.OnClickListener() { //I call the onClickListener function
            public void onClick(View v) {//if the alliance trench button is clicked, then this executes
                oppTrenchIsClicked = true;
                opponentTrenchCount.setText(Integer.toString(oppTrenchCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        opponentTrenchUndoOperation();
                    }
                });
            }
        });
    }
    public void opponentTrenchUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(oppTrenchCount);
        while (stk.firstElement() == oppTrenchCount) {
            opponentTrenchCount.setText(Integer.toString(oppTrenchCount -= 1));
        }
        stk.pop();
    }
}