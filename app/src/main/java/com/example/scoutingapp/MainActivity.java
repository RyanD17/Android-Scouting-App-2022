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

    Button allianceTrenchBtn;
    TextView allianceTrenchBtnCount;
    Button rendezvousBtn;
    TextView rendezvousBtnCount;
    Button opponentTrenchBtn;
    TextView opponentTrenchCount;
    Button autoHighMissBtn;
    TextView autoHighMissBtnCount;
    Button autoHighHitBtn;
    TextView autoHighHitBtnCount;
    Button autoLowMissBtn;
    TextView autoLowMissTxt;
    Button autoLowHitBtn;
    TextView autoLowHitTxt;
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

    float x1, x2, y1, y2;

    public int allianceTrenchCount = 0;
    public int rendezvousCount = 0;
    public int oppTrenchCount = 0;
    public int autoHighMissCount = 0;
    public int autoHighHitCount = 0;
    public int autoLowMissCount = 0;
    public int autoLowHitCount = 0;

    CountDownTimer countDownTimer;

    CommentActivity commentActivity = new CommentActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        //initializing variables

        allianceTrenchBtn = findViewById(R.id.alliance_trench);
        allianceTrenchBtnCount = findViewById(R.id.AllianceTrenchCount);
        rendezvousBtn = findViewById(R.id.rendezvous);
        rendezvousBtnCount = findViewById(R.id.RendezvousCount);
        opponentTrenchBtn = findViewById(R.id.opponentTrench);
        opponentTrenchCount = findViewById(R.id.OppTrenchCount);
        autoHighMissBtn = findViewById(R.id.autoHighMiss);
        autoHighMissBtnCount = findViewById(R.id.autoHighMissCount);
        autoHighHitBtn = findViewById(R.id.autoHighHit);
        autoHighHitBtnCount = findViewById(R.id.autoHighHitCount);
        autoLowMissBtn = findViewById(R.id.autoLowMiss);
        autoLowMissTxt = findViewById(R.id.autoLowMissCount);
        autoLowHitBtn = findViewById(R.id.autoLowHit);
        autoLowHitTxt = findViewById(R.id.autoLowHitCount);
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
        allianceTrenchBtn.setOnClickListener(new View.OnClickListener() { //I call the onClickListener function
            public void onClick(View v) {//if the alliance trench button is clicked, then this executes
                isClicked = true;
                allianceTrenchBtnCount.setText(Integer.toString(allianceTrenchCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        allianceTrenchUndoOperation();
                    }
                });
            }
        });


        //code for making the rendezvous button work
        rendezvousBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                rendezvousBtnCount.setText(Integer.toString(rendezvousCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rendezvousUndoOperation();
                    }
                });
            }
        });

        //code for making the opponent trench button work
        opponentTrenchBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                opponentTrenchCount.setText(Integer.toString(oppTrenchCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oppTrenchUndoOperation();
                    }
                });
            }
        });

        //code for making the auto high hit button work
        autoHighHitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                autoHighHitBtnCount.setText(Integer.toString(autoHighHitCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoHighHitUndoOperation();
                    }
                });
            }
        });

        //code for making the auto low hit button work
        autoLowHitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                autoLowHitTxt.setText(Integer.toString(autoLowHitCount++));

                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoLowHitUndoOperation();
                    }
                });
            }
        });

        //code for making the auto high miss button work
        autoHighMissBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                autoHighMissBtnCount.setText(Integer.toString(autoHighMissCount++));

                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoHighMissUndoOperation();
                    }
                });
            }
        });

        //code for making the auto low miss button work
        autoLowMissBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isClicked = true;
                autoLowMissTxt.setText(Integer.toString(autoLowMissCount++));

                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoLowMissUndoOperation();
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

    private void autoLowMissUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(autoLowMissCount);
        while (stk.firstElement() == autoLowMissCount) {
            autoLowMissTxt.setText(Integer.toString(autoLowMissCount -= 1));
        }
        stk.pop();
    }

    private void autoHighMissUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(autoHighMissCount);
        while (stk.firstElement() == autoHighMissCount) {
            autoHighMissBtnCount.setText(Integer.toString(autoHighMissCount -= 1));
        }
        stk.pop();
    }

    private void autoLowHitUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(autoLowHitCount);
        while (stk.firstElement() == autoLowHitCount) {
            autoLowHitTxt.setText(Integer.toString(autoLowHitCount -= 1));
        }
        stk.pop();
    }

    private void autoHighHitUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(autoHighHitCount);
        while (stk.firstElement() == autoHighHitCount) {
            autoHighHitBtnCount.setText(Integer.toString(autoHighHitCount -= 1));
        }
        stk.pop();
    }

    private void oppTrenchUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(oppTrenchCount);
        while (stk.firstElement() == oppTrenchCount) {
            opponentTrenchCount.setText(Integer.toString(oppTrenchCount -= 1));
        }
        stk.pop();
    }

    private void rendezvousUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(rendezvousCount);
        while (stk.firstElement() == rendezvousCount) {
            rendezvousBtnCount.setText(Integer.toString(rendezvousCount -= 1));
        }
        stk.pop();
    }

    private void allianceTrenchUndoOperation() {
        Stack<Integer> stk = new Stack<>();
        stk.push(allianceTrenchCount);
        while (stk.firstElement() == allianceTrenchCount) {
            allianceTrenchBtnCount.setText(Integer.toString(allianceTrenchCount -= 1));
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

        int progressTime = 165- timeLeft ;

        String TimeToString = Integer.toString(progressTime);

        matchTimer.setProgress(progressTime);
        timer_txt.setText(TimeToString);
    }
}