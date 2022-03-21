package com.example.scoutingapp.autoscreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.CommentActivity;
import com.example.scoutingapp.R;
import com.example.scoutingapp.teleop_screen.teleop;

import java.util.Stack;


public class MainActivity extends AppCompatActivity {


    public Stack<Integer> stk = new Stack<>();

    public Button autoHighMissBtn, autoHighHitBtn, autoLowMissBtn, autoLowHitBtn, goToTeleop;
    public TextView autoHighMissBtnCount, autoHighHitBtnCount, autoLowMissTxt, autoLowHitTxt;

    public ImageButton undoButton;
    public ImageButton commentButton;

    public int autoHighMissCount = 0, autoHighHitCount = 0, autoLowMissCount = 0 , autoLowHitCount = 0;
    public boolean autoHighHit_isClicked = false, autoHighMiss_isClicked = false, autoLowHit_isClicked = false, autoLowMiss_isClicked = false;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        //initializing variables
        autoHighMissBtn=findViewById(R.id.autoHighMiss);
        autoHighMissBtnCount=findViewById(R.id.autoHighMissCount);
        autoHighHitBtn=findViewById(R.id.autoHighHit);
        autoHighHitBtnCount=findViewById(R.id.autoHighHitCount);
        autoLowMissBtn=findViewById(R.id.autoLowMiss);
        autoLowMissTxt=findViewById(R.id.autoLowMissCount);
        autoLowHitBtn=findViewById(R.id.autoLowHit);
        autoLowHitTxt=findViewById(R.id.autoLowHitCount);
        commentButton = findViewById(R.id.commentBtn);
        undoButton = findViewById(R.id.undoButton);
        goToTeleop = findViewById(R.id.goToTeleop);


        //calling each method inside of robotHitMiss
        autoHighMiss_isPressed();
        autoLowMiss_isPressed();
        autoHighHit_isPressed();
        autoLowHit_isPressed();

        commentButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CommentActivity.class);
            startActivity(intent);
        });

        goToTeleop.setOnClickListener(v -> {
            Intent teleopIntent = new Intent(MainActivity.this, teleop.class);
            startActivity(teleopIntent);
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
}