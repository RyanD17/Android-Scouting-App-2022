package com.example.scoutingapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class matchRow extends AppCompatActivity {

        private CheckBox r1;
        private EditText scout_name;
        private EditText event_name;

        public boolean isR1Pressed = false;

        @SuppressLint("WrongViewCast")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.match_row);


            r1=findViewById(R.id.red_1);
            scout_name = findViewById(R.id.scout_name);
            event_name = findViewById(R.id.event_name);

            r1.setOnClickListener(v -> {
                isR1Pressed = true;
                Intent intent=new Intent(this, select_board.class);
                startActivity(intent);
            });
            isR1Pressed = false;
        }
}