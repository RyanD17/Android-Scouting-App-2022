package com.example.scoutingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class allianceTrench extends MainActivity {
    Button allianceTrenchBtn;
    TextView allianceTrenchBtnCount;

    public int allianceTrenchCount = 0;


    public allianceTrench allianceTrenchObj = new allianceTrench();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        allianceTrenchBtn = findViewById(R.id.alliance_trench);
        allianceTrenchBtnCount = findViewById(R.id.AllianceTrenchCount);


        //code for making the alliance trench button work
        allianceTrenchBtn.setOnClickListener(new View.OnClickListener() { //I call the onClickListener function
            public void onClick(View v) {//if the alliance trench button is clicked, then this executes
                allianceTrenchObj.isClicked = true;
                allianceTrenchObj.allianceTrenchBtnCount.setText(Integer.toString(allianceTrenchCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        allianceTrenchUndoOperation();
                    }
                });
            }
        });
    }
    public void allianceTrenchUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(allianceTrenchCount);
        while (stk.firstElement() == allianceTrenchCount) {
            allianceTrenchBtnCount.setText(Integer.toString(allianceTrenchCount -= 1));
        }
        stk.pop();
    }
}