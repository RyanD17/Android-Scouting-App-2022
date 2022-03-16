package com.example.scoutingapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.autoscreen.robotHitMiss;

public class timer extends AppCompatActivity {

    ProgressBar matchTimer;
    TextView timer_txt;
    Button startTimer;
    ImageButton pauseTimer;


    public boolean isTimerRunning = false;

    robotHitMiss robotHitMissObj = new robotHitMiss();

    public long timeLeftInMilliseconds = 165000;
    CountDownTimer countDownTimer;

    public int timeLeft = (int) (timeLeftInMilliseconds) / 1000;

    public int progressTime = 165 - timeLeft ;

    public String TimeToString = Integer.toString(progressTime);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        matchTimer = findViewById(R.id.matchTimer);
        timer_txt = findViewById(R.id.timerTxt);
        startTimer = findViewById(R.id.startMatchTimer);
        pauseTimer = findViewById(R.id.pauseBtn);


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
        pauseTimer.setOnClickListener(v -> pauseTimer());
    }

    public void startTimer() {
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
        robotHitMissObj.undoButton.setVisibility(View.VISIBLE);
    }
    public void pauseTimer() {
        countDownTimer.cancel();
        isTimerRunning = false;
        startTimer.setVisibility(View.VISIBLE);
        pauseTimer.setVisibility(View.INVISIBLE);
        robotHitMissObj.undoButton.setVisibility(View.INVISIBLE);
        updateCountDownText();
    }

   public void updateCountDownText() {
        matchTimer.setProgress(progressTime);
        timer_txt.setText(TimeToString);
    }
}