package com.example.scoutingapp.teleop_screen;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.R;
import com.example.scoutingapp.timer;

public class teleop extends AppCompatActivity {

    //creating variables and objects
    public timer timerObj = new timer();
    public robotHitMissTeleop robotHitMissTeleopObj = new robotHitMissTeleop();

    Button HighMissBtn, HighHitBtn, LowMissBtn, LowHitBtn;
    TextView HighMissBtnCount, HighHitBtnCount, LowMissTxt, LowHitTxt;

    public int HighMissCount, HighHitCount, LowMissCount, LowHitCount;
    public boolean HighHit_isClicked, LowHit_isClicked, HighMiss_isClicked, LowMiss_isClicked;

    public ImageButton undoButton;
    public ImageButton commentButton;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_screen);

        HighMissBtn=findViewById(R.id.highMiss);
        HighMissBtnCount=findViewById(R.id.highMiss_txt);
        HighHitBtn=findViewById(R.id.highHit);
        HighHitBtnCount=findViewById(R.id.highHit_txt);
        LowMissBtn=findViewById(R.id.lowMiss);
        LowMissTxt=findViewById(R.id.lowMiss_txt);
        LowHitBtn=findViewById(R.id.lowHit);
        LowHitTxt=findViewById(R.id.lowHit_txt);
        undoButton=findViewById(R.id.undoButton);
        commentButton=findViewById(R.id.commentBtn);

        robotHitMissTeleopObj.HighMiss_isPressed();
        robotHitMissTeleopObj.LowMiss_isPressed();
        robotHitMissTeleopObj.HighHit_isPressed();
        robotHitMissTeleopObj.LowHit_isPressed();
    }
}
