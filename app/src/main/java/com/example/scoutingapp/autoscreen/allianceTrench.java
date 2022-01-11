package com.example.scoutingapp.autoscreen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.scoutingapp.R;

import java.util.ArrayList;
import java.util.Stack;

public class allianceTrench extends MainActivity {
    public Button allianceTrenchBtn;
    public TextView allianceTrenchBtnCount;

    public ArrayList<Integer> allianceTrenchData = new ArrayList<Integer>();


    public int allianceTrenchCount = 0;
    public boolean allianceTrench_isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        allianceTrenchBtn = findViewById(R.id.alliance_trench);
        allianceTrenchBtnCount = findViewById(R.id.AllianceTrenchCount);
    }
        public void allianceTrenchIsPressed(){
            //code for making the alliance trench button work
            allianceTrenchBtn.setOnClickListener(new View.OnClickListener() { //I call the onClickListener function
                public void onClick(View v) {//if the alliance trench button is clicked, then this executes
                    allianceTrench_isClicked = true;
                    allianceTrenchBtnCount.setText(Integer.toString(allianceTrenchCount++));
                    allianceTrenchData.add(allianceTrenchCount);
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
            allianceTrenchData.remove(allianceTrenchCount -= 1);
        }
        stk.pop();
    }
}