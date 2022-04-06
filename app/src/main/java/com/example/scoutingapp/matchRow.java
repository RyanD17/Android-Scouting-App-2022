package com.example.scoutingapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.autoscreen.MainActivity;

import java.util.ArrayList;

public class matchRow extends AppCompatActivity {

        private CheckBox r1;
        public TextView M1, R1, R2, R3, B1, B2, B3;
        public TextView scout_name;
        public TextView event_name;

        public boolean isR1Pressed = false;
        public boolean isR2Pressed = false;
        public boolean isR3Pressed = false;

        public boolean isB1Pressed = false;
        public boolean isB2Pressed = false;
        public boolean isB3Pressed = false;

        ArrayList<String> teamNum = new ArrayList<>();


        @SuppressLint("WrongViewCast")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.match_row);


            r1=findViewById(R.id.red_1);
            event_name = findViewById(R.id.event_name);
            M1 = findViewById(R.id.match_num);
            R1 = findViewById(R.id.teamRed1);
            R2 = findViewById(R.id.teamRed2);
            R3 = findViewById(R.id.teamRed3);

            B1 = findViewById(R.id.teamBlue1);
            B2 = findViewById(R.id.teamBlue2);
            B3 = findViewById(R.id.teamBlue3);

            teamNum.add("865");
            teamNum.add("1325");
            teamNum.add("1114");
            teamNum.add("2200");
            teamNum.add("4476");


            R1.setText(teamNum.get(0));
            R2.setText(teamNum.get(1));
            R2.setText(teamNum.get(2));
            R3.setText(teamNum.get(3));


            r1.setOnClickListener(v -> {
                isR1Pressed = true;
                Intent intent=new Intent(this, select_board.class);
                startActivity(intent);
            });
            isR1Pressed = false;

            M1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view) {
                    openAutoScreen();
                }
            });
            R1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view) {
                    isR1Pressed = true;
                    openAutoScreen();
                }
            });
            isR1Pressed = false;
            R2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view) {
                    isR2Pressed =  true;
                    openAutoScreen();
                }
            });
            isR2Pressed = false;
            R3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view) {
                    isR3Pressed = true;
                    openAutoScreen();
                }
            });
            isR3Pressed = false;
            B1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view) {
                    isB1Pressed = true;
                    openAutoScreen();
                }
            });
            isB1Pressed = false;
            B2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view) {
                    isB2Pressed  = true;
                    openAutoScreen();
                }
            });
            isB2Pressed = false;
            B3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view) {
                    isB3Pressed = true;
                    openAutoScreen();
                }
            });
            isB3Pressed = false;
        }
    public void openAutoScreen(){
            Intent autoIntent = new Intent(matchRow.this, MainActivity.class);
            startActivity(autoIntent);
        }
}