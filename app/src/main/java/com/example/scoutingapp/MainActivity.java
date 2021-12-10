package com.example.scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Stack;


public class MainActivity<data> extends AppCompatActivity {

    ProgressBar matchTimer;
    TextView timer_txt;
    Button startTimer;
    ImageButton pauseTimer;
    ImageButton undoButton;
    ImageButton commentBtn;

    public boolean isClicked = false;
    public boolean isTimerRunning = false;

    public long timeLeftInMilliseconds = 165000;

    float x1, x2, y1, y2;

    CountDownTimer countDownTimer;

    CommentActivity commentActivity = new CommentActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        //initializing variables

        matchTimer = findViewById(R.id.matchTimer);
        timer_txt = findViewById(R.id.timerTxt);
        startTimer = findViewById(R.id.startMatchTimer);
        pauseTimer = findViewById(R.id.pauseBtn);
        commentBtn = findViewById(R.id.commentBtn);
        undoButton = findViewById(R.id.undoButton);

        //code for the Timer
        matchTimer.setMax(165);
        matchTimer.setProgress(0);

        timer_txt.setText("0");

        startTimer.setOnClickListener(v -> {
            if (isTimerRunning) {
                pauseTimer();
            } else {
                startTimer();
            }

        });
        pauseTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
            }
        });
        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCommentActivity();
            }
        });
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
    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                isTimerRunning = false;
                pauseTimer();
                timer_txt.setText("0");
                matchTimer.setProgress(0);
            }
        }.start();

        isTimerRunning = true;

        startTimer.setVisibility(View.INVISIBLE);
        pauseTimer.setVisibility(View.VISIBLE);
        undoButton.setVisibility(View.VISIBLE);
    }
    private void pauseTimer() {
        countDownTimer.cancel();
        isTimerRunning = false;
        startTimer.setVisibility(View.VISIBLE);
        pauseTimer.setVisibility(View.INVISIBLE);
        undoButton.setVisibility(View.INVISIBLE);
        updateCountDownText();
    }

    private void updateCountDownText() {

        int timeLeft = (int) (timeLeftInMilliseconds) / 1000;

        int progressTime = 165- timeLeft ;

        String TimeToString = Integer.toString(progressTime);

        matchTimer.setProgress(progressTime);
        timer_txt.setText(TimeToString);
    }
}