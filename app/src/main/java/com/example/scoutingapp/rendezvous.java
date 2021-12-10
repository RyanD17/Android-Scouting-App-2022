package com.example.scoutingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class rendezvous extends MainActivity {
    Button rendezvousBtn;
    TextView rendezvousBtnCount;
    public int rendezvousCount = 0;

    public rendezvous rendezvousObj = new rendezvous();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        rendezvousBtn = findViewById(R.id.rendezvous);
        rendezvousBtnCount = findViewById(R.id.RendezvousCount);


        //code for making the alliance trench button work
        rendezvousBtn.setOnClickListener(new View.OnClickListener() { //I call the onClickListener function
            public void onClick(View v) {//if the alliance trench button is clicked, then this executes
                rendezvousObj.isClicked = true;
                rendezvousObj.rendezvousBtnCount.setText(Integer.toString(rendezvousCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rendezvousUndoOperation();
                    }
                });
            }
        });
    }
    private void rendezvousUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(rendezvousCount);
        while (stk.firstElement() == rendezvousCount) {
            rendezvousBtnCount.setText(Integer.toString(rendezvousCount -= 1));
        }
        stk.pop();
    }
}