package com.example.scoutingapp.autoscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageButton;
import com.example.scoutingapp.R;
import com.example.scoutingapp.teleop_screen.teleop;


public class MainActivity<data> extends AppCompatActivity {

    public ImageButton undoButton;


    public robotHitMiss robotHitMissObj = new robotHitMiss();


    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        //initializing variables
        undoButton = findViewById(R.id.undoButton);
    }
    public void robotHitMiss (){
        if (robotHitMissObj.autoHighHit_isClicked){
            robotHitMissObj.autoHighHit_isPressed();
        }
        else if (robotHitMissObj.autoLowHit_isClicked){
            robotHitMissObj.autoLowHit_isPressed();
        }
        else if (robotHitMissObj.autoLowMiss_isClicked){
            robotHitMissObj.autoLowMiss_isPressed();
        }
    }
    public boolean onTouchEvent(MotionEvent touchEvent){
        switch (touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1 < x2){
                    Intent intent = new Intent(MainActivity.this, teleop.class);
                    startActivity(intent);
                }
                break;
        }
        return false;
    }
    public void openCommentActivity () {
        Intent intent = new Intent(this, com.example.scoutingapp.CommentActivity.class);
        startActivity(intent);
    }
}