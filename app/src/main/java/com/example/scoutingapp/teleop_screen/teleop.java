package com.example.scoutingapp.teleop_screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.scoutingapp.CommentActivity;
import com.example.scoutingapp.R;
import com.example.scoutingapp.autoscreen.MainActivity;
import com.example.scoutingapp.autoscreen.robotHitMiss;
import com.example.scoutingapp.timer;

public class teleop extends MainActivity {

    //creating variables
    ProgressBar matchTimer;
    TextView timer_txt;
    Button startTimer;
    ImageButton pauseTimer;
    ImageButton undoButton;
    ImageButton commentBtn;

    public timer timerObj = new timer();
    public controlPanel controlPanelObj = new controlPanel();
    public defending defendingObj = new defending();
    public resisting resistingObj = new resisting();
    public CommentActivity commentActivityObj = new CommentActivity();
    public robotHitMiss robotHitMissObj = new robotHitMiss();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_screen);

        //initializing variables
        matchTimer = findViewById(R.id.matchTimer);
        timer_txt = findViewById(R.id.timerTxt);
        startTimer = findViewById(R.id.startMatchTimer);
        pauseTimer = findViewById(R.id.pauseBtn);
        commentBtn = findViewById(R.id.commentBtn);
        undoButton = findViewById(R.id.undoButton);

        if (timerObj.isTimerRunning){ // if the timer is running then this code will execute
            timerObj.startTimer();
            timerObj.updateCountDownText();
        }
        else{
            timerObj.pauseTimer();
        }
        commentBtn.setOnClickListener(new View.OnClickListener() {//if the comment button is pressed then this code will execute
            @Override
            public void onClick(View v) {
                openCommentActivity();
            }
        });
    }
    public void openCommentActivity() {
        Intent intent = new Intent(this, com.example.scoutingapp.CommentActivity.class);
        startActivity(intent);
    }
}
