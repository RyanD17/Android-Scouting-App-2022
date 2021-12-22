package com.example.scoutingapp.autoscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageButton;

import com.example.scoutingapp.CommentActivity;
import com.example.scoutingapp.R;
import com.example.scoutingapp.fieldArea;
import com.example.scoutingapp.teleop_screen.teleop;


public class MainActivity<data> extends AppCompatActivity {

    public ImageButton commentBtn;
    public ImageButton undoButton;

    public allianceTrench allianceTrenchObj = new allianceTrench();
    public fieldArea fieldAreaButtonsObj = new fieldArea();
    public opponentTrench opponentTrenchObj = new opponentTrench();
    public CommentActivity commentActivityObj = new CommentActivity();
    public rendezvous rendezvousObj = new rendezvous();
    public robotHitMiss robotHitMissObj = new robotHitMiss();


    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        //initializing variables
        undoButton = findViewById(R.id.undoButton);

        if (allianceTrenchObj.allianceTrench_isClicked){
            allianceTrenchObj.allianceTrenchIsPressed();
        }
        else{
            allianceTrenchObj.allianceTrench_isClicked = false;
        }

        if (robotHitMissObj.autoHighHit_isClicked){
            robotHitMissObj.autoHighHit_isPressed();
            robotHitMissObj.autoHighHit_isClicked = true;
        }
        else{
            robotHitMissObj.autoHighHit_isClicked = false;
        }

        if (robotHitMissObj.autoLowHit_isClicked){
            robotHitMissObj.autoHighMiss_isPressed();
            robotHitMissObj.autoHighHit_isClicked = true;
        }
        else{
            robotHitMissObj.autoHighHit_isClicked = false;
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
    public void openCommentActivity() {
        Intent intent = new Intent(this, com.example.scoutingapp.CommentActivity.class);
        startActivity(intent);
    }
}