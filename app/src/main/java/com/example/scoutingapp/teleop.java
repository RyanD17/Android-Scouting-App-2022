package com.example.scoutingapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Stack;

public class teleop extends MainActivity {

    ToggleButton controlPanel;
    ToggleButton defending;
    ToggleButton resisting;
    Button HighMissBtn;
    TextView HighMissBtnCount;
    Button HighHitBtn;
    TextView HighHitBtnCount;
    Button LowMissBtn;
    TextView LowMissTxt;
    Button LowHitBtn;
    TextView LowHitTxt;
    ToggleButton crossBtn;
    ToggleButton trenchBtn;
    ToggleButton midBtn;
    ToggleButton targetBtn;


    ProgressBar matchTimer;
    TextView timer_txt;
    Button startTimer;
    ImageButton pauseTimer;
    ImageButton undoButton;
    ImageButton commentBtn;

    public boolean isClicked = false;
    public boolean isTimerRunning = false;

    public long timeLeftInMilliseconds = 165000;

    public int HighMissCount = 0;
    public int HighHitCount = 0;
    public int LowMissCount = 0;
    public int LowHitCount = 0;

    CountDownTimer countDownTimer;

    CommentActivity commentActivity = new CommentActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_screen);

        //initializing variables

        controlPanel = findViewById(R.id.control_panel);
        defending = findViewById(R.id.defending);
        resisting = findViewById(R.id.risisting);
        HighMissBtn = findViewById(R.id.autoHighMiss);
        HighMissBtnCount = findViewById(R.id.autoHighMissCount);
        HighHitBtn = findViewById(R.id.autoHighHit);
        HighHitBtnCount = findViewById(R.id.autoHighHitCount);
        LowMissBtn = findViewById(R.id.autoLowMiss);
        LowMissTxt = findViewById(R.id.autoLowMissCount);
        LowHitBtn = findViewById(R.id.autoLowHit);
        LowHitTxt = findViewById(R.id.autoLowHitCount);
        crossBtn = findViewById(R.id.crossBtn);
        trenchBtn = findViewById(R.id.trenchBtn);
        midBtn = findViewById(R.id.midBtn);
        targetBtn = findViewById(R.id.targetBtn);


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

        //code for making the alliance trench button work
        controlPanel.setOnClickListener(new View.OnClickListener() { //I call the onClickListener function
            public void onClick(View v) {//if the alliance trench button is clicked, then this executes
                isClicked = true;
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        });


        //code for making the rendezvousObj button work
        defending.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        });

        //code for making the opponent trench button work
        resisting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        });

        //code for making the  high hit button work
        HighHitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                HighHitBtnCount.setText(Integer.toString(HighHitCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HighHitUndoOperation();
                    }
                });
            }
        });

        //code for making the  low hit button work
        LowHitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                LowHitTxt.setText(Integer.toString(LowHitCount++));

                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LowHitUndoOperation();
                    }
                });
            }
        });

        //code for making the  high miss button work
        HighMissBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                HighMissBtnCount.setText(Integer.toString(HighMissCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HighMissUndoOperation();
                    }
                });
            }
        });

        //code for making the  low miss button work
        LowMissBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                LowMissTxt.setText(Integer.toString(LowMissCount++));

                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LowMissUndoOperation();
                    }
                });
            }
        });

        crossBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    isClicked = true;
                    midBtn.setBackgroundColor(Color.RED);
                    trenchBtn.setBackgroundColor(Color.RED);
                    targetBtn.setBackgroundColor(Color.RED);
                    crossBtn.setBackgroundColor(Color.GREEN);
                } else {
                    isClicked = false;
                    crossBtn.setBackgroundColor(Color.RED);
                }
            }
        });

        trenchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    isClicked = true;
                    midBtn.setBackgroundColor(Color.RED);
                    crossBtn.setBackgroundColor(Color.RED);
                    targetBtn.setBackgroundColor(Color.RED);
                    trenchBtn.setBackgroundColor(Color.GREEN);
                } else {
                    isClicked = false;
                    trenchBtn.setBackgroundColor(Color.RED);
                }
            }
        });

        //code for making the mid button work
        midBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    isClicked = true;
                    trenchBtn.setBackgroundColor(Color.RED);
                    crossBtn.setBackgroundColor(Color.RED);
                    targetBtn.setBackgroundColor(Color.RED);
                    midBtn.setBackgroundColor(Color.GREEN);
                } else {
                    isClicked = false;
                    midBtn.setBackgroundColor(Color.RED);
                }
            }
        });

        targetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    isClicked = true;
                    midBtn.setBackgroundColor(Color.RED);
                    trenchBtn.setBackgroundColor(Color.RED);
                    crossBtn.setBackgroundColor(Color.RED);
                    targetBtn.setBackgroundColor(Color.GREEN);
                } else {
                    targetBtn.setBackgroundColor(Color.RED);
                }
            }
        });
    }



    public void openCommentActivity() {
        Intent intent = new Intent(this, com.example.scoutingapp.CommentActivity.class);
        startActivity(intent);

    }

    private void LowMissUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(LowMissCount);
        while (stk.firstElement() == LowMissCount) {
            LowMissTxt.setText(Integer.toString(LowMissCount -= 1));
        }
        stk.pop();
    }

    private void HighMissUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(HighMissCount);
        while (stk.firstElement() == HighMissCount) {
            HighMissBtnCount.setText(Integer.toString(HighMissCount -= 1));
        }
        stk.pop();
    }

    private void LowHitUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(LowHitCount);
        while (stk.firstElement() == LowHitCount) {
            LowHitTxt.setText(Integer.toString(LowHitCount -= 1));
        }
        stk.pop();
    }

    private void HighHitUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(HighHitCount);
        while (stk.firstElement() == HighHitCount) {
            HighHitBtnCount.setText(Integer.toString(HighHitCount -= 1));
        }
        stk.pop();
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

        int progressTime = 165 - timeLeft;

        String TimeToString = Integer.toString(progressTime);

        matchTimer.setProgress(progressTime);
        timer_txt.setText(TimeToString);
    }
}
