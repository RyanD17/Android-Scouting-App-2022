package com.example.scoutingapp.autoscreen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.CommentActivity;
import com.example.scoutingapp.R;


public class MainActivity extends AppCompatActivity {

    robotHitMiss robotHitMissObj = new robotHitMiss();

    public Button autoHighMissBtn, autoHighHitBtn, autoLowMissBtn, autoLowHitBtn;
    public TextView autoHighMissBtnCount, autoHighHitBtnCount, autoLowMissTxt, autoLowHitTxt;

    public ImageButton undoButton;
    public ImageButton commentButton;

    public int autoHighMissCount = 0, autoHighHitCount = 0, autoLowMissCount = 0 , autoLowHitCount = 0;
    public boolean autoHighHit_isClicked = false, autoHighMiss_isClicked = false, autoLowHit_isClicked = false, autoLowMiss_isClicked = false;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        //initializing variables
        autoHighMissBtn=findViewById(R.id.autoHighMiss);
        autoHighMissBtnCount=findViewById(R.id.autoHighMissCount);
        autoHighHitBtn=findViewById(R.id.autoHighHit);
        autoHighHitBtnCount=findViewById(R.id.autoHighHitCount);
        autoLowMissBtn=findViewById(R.id.autoLowMiss);
        autoLowMissTxt=findViewById(R.id.autoLowMissCount);
        autoLowHitBtn=findViewById(R.id.autoLowHit);
        autoLowHitTxt=findViewById(R.id.autoLowHitCount);

        //calling each method inside of robotHitMiss
        robotHitMissObj.autoHighMiss_isPressed();
        robotHitMissObj.autoLowMiss_isPressed();
        robotHitMissObj.autoHighHit_isPressed();
        robotHitMissObj.autoLowHit_isPressed();

        commentButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, CommentActivity.class);
            startActivity(intent);
        });
    }
}