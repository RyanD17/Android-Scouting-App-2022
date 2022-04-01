package com.example.scoutingapp.teleop_screen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.CommentActivity;
import com.example.scoutingapp.R;
import com.example.scoutingapp.autoscreen.MainActivity;
import com.example.scoutingapp.endgame.endgame;
import com.example.scoutingapp.timer;

import java.util.Stack;

public class teleop extends AppCompatActivity {

    //creating variables and objects
    public timer timerObj = new timer();


    public Stack<Integer> stk = new Stack<>();

    private Button foul;//creating a new button with the name foul
    private TextView foul_counter;

    private Button tech_foul;
    private TextView tech_foul_counter;
    public  int foul_count = 0, defenceCount = 0;
    public int tech_foul_count = 0;


    Button HighMissBtn, HighHitBtn, LowMissBtn, LowHitBtn, goToAuto, goToEndgame, startTimerBtn;
    TextView HighMissBtnCount, HighHitBtnCount, LowMissTxt, LowHitTxt;

    public int HighMissCount, HighHitCount, LowMissCount, LowHitCount;
    public boolean HighHit_isClicked, LowHit_isClicked, HighMiss_isClicked, LowMiss_isClicked;

    public ImageButton undoButton;
    public ImageButton commentButton;

    public Button defense;
    public boolean defending_isClicked = false;

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
        startTimerBtn = findViewById(R.id.startMatchTimer);
        undoButton=findViewById(R.id.undoButton);
        commentButton=findViewById(R.id.commentBtn);
        defense = findViewById(R.id.defending);
        foul = findViewById(R.id.foul);
        foul_counter = findViewById(R.id.foul_count);
        tech_foul = findViewById(R.id.tech_foul);
        tech_foul_counter = findViewById(R.id.tech_foul_count);
        goToAuto =  findViewById(R.id.toAuto);
        goToEndgame = findViewById(R.id.toEndgame);

        defenseBtn();
        foul_database();
        HighMiss_isPressed();
        LowMiss_isPressed();
        HighHit_isPressed();
        LowHit_isPressed();

        goToAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent autoIntent = new Intent(teleop.this, MainActivity.class);
                startActivity(autoIntent);
            }
        });
        goToEndgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent endgameIntent = new Intent(teleop.this, endgame.class);
                startActivity(endgameIntent);
            }
        });
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent commentIntent = new Intent(teleop.this, CommentActivity.class);
                startActivity(commentIntent);
            }
        });

    }
    public void defenseBtn(){
        defense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                while (defending_isClicked){
                    defending_isClicked = true;
                    defense.setBackgroundColor(Color.GREEN);
                    defenceCount ++;
                }
                defending_isClicked = false;
                defenceCount += 0;
                defense.setBackgroundColor(Color.RED);
            }
        });
    }
    public void undoOperationTeleop() {
        switch (stk.firstElement()) {
            case 1:
                stk.push(LowMissCount);
                while (stk.firstElement() == LowMissCount) {
                    LowMissTxt.setText(Integer.toString(LowMissCount-=1));
                }
                stk.pop();
            case 3:
                stk.push(HighMissCount);
                while (stk.firstElement() == HighMissCount) {
                    HighMissBtnCount.setText(Integer.toString(HighMissCount-=1));
                }
                stk.pop();
            case 4:
                stk.push(LowHitCount);
                while (stk.firstElement() == LowHitCount) {
                    LowHitTxt.setText(Integer.toString(LowHitCount-=1));
                }
                stk.pop();
            case 5:
                Stack<Integer> stk=new Stack<>();
                stk.push(HighHitCount);
                while (stk.firstElement() == HighHitCount) {
                    HighHitBtnCount.setText(Integer.toString(HighHitCount-=1));
                }
                stk.pop();
        }
    }
    public void LowMiss_isPressed () {
        //code for making the  low miss button work
        LowMissBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                LowMiss_isClicked=true;
                LowMissTxt.setText(Integer.toString(LowMissCount++));

                undoButton.setOnClickListener(v1 -> undoOperationTeleop());
            }
        });
    }
    @SuppressLint("SetTextI18n")
    public void HighMiss_isPressed () {
        //code for making the  high miss button work
        HighMissBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                HighMiss_isClicked=true;
                HighMissBtnCount.setText(Integer.toString(HighMissCount++));

                undoButton.setOnClickListener(v1 -> undoOperationTeleop());
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void LowHit_isPressed () {
        //code for making the  low hit button work
        LowHitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                LowHit_isClicked=true;
                LowHitTxt.setText(Integer.toString(LowHitCount++));
                undoButton.setOnClickListener(v1 -> undoOperationTeleop());
            }
        });
    }
    public void HighHit_isPressed(){
        //code for making the  high hit button work
        HighHitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                HighHit_isClicked=true;
                HighHitBtnCount.setText(Integer.toString(HighHitCount++));
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick (View v) {
                        undoOperationTeleop();
                    }
                });
            }
        });
    }
    public void foul_database(){
        foul.setOnClickListener(v -> {
            foul_counter.setText(Integer.toString(foul_count++));
        });
        tech_foul.setOnClickListener(v -> {
            tech_foul_counter.setText(Integer.toString(tech_foul_count++));
        });
    }

}
