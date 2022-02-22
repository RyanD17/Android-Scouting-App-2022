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
    ImageButton undoButton;
    ImageButton commentBtn;

    public timer timerObj = new timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_screen);

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
}
