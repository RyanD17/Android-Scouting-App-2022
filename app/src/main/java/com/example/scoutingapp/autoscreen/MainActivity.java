package com.example.scoutingapp.autoscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import com.example.scoutingapp.CommentActivity;
import com.example.scoutingapp.R;
import com.example.scoutingapp.teleop_screen.teleop;


public class MainActivity<data> extends AppCompatActivity {

    public ImageButton undoButton;
    public ImageButton commentButton;



    public robotHitMiss robotHitMissObj = new robotHitMiss();
    float x1, x2, y1, y2;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        //initializing variables
        undoButton=findViewById(R.id.undoButton);
        commentButton=findViewById(R.id.commentBtn);

        commentButton.setOnClickListener(v -> {
            Intent intent=new Intent(this, com.example.scoutingapp.CommentActivity.class);
            startActivity(intent);
        });



    }

    public boolean robotHitMiss_isClicked(){
        if (robotHitMissObj.autoLowMiss_isClicked){
            robotHitMissObj.autoLowMiss_isPressed();
            return true;
        }

        else if (robotHitMissObj.autoLowHit_isClicked){
            robotHitMissObj.autoLowHit_isPressed();
            return true;
        }

        else if (robotHitMissObj.autoHighHit_isClicked){
            robotHitMissObj.autoHighHit_isPressed();
            return true;
        }
        else if (robotHitMissObj.autoHighMiss_isClicked){
            robotHitMissObj.autoHighMiss_isPressed();
        }

        else if (robotHitMissObj.LowMiss_isClicked){
            robotHitMissObj.LowMiss_isPressed();
            return true;
        }

        else if (robotHitMissObj.LowHit_isClicked){
            robotHitMissObj.LowHit_isPressed();
            return true;
        }

        else if (robotHitMissObj.HighHit_isClicked){
            robotHitMissObj.autoHighHit_isPressed();
            return true;
        }
        else if (robotHitMissObj.HighMiss_isClicked){
            robotHitMissObj.HighMiss_isPressed();
        }
        return false;
    }

    public boolean onTouchEvent (MotionEvent touchEvent) {
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1=touchEvent.getX();
                y1=touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2=touchEvent.getX();
                y2=touchEvent.getY();
                if (x1 < x2) {
                    Intent intent=new Intent(MainActivity.this, teleop.class);
                    startActivity(intent);
                }
                break;
        }
        return false;
    }
}