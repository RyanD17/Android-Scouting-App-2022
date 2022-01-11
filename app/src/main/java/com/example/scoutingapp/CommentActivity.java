package com.example.scoutingapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.scoutingapp.autoscreen.MainActivity;

import java.util.ArrayList;

public class CommentActivity extends MainActivity {

    public CheckBox robot_disabled;
    public CheckBox robot_incapacitated;
    public CheckBox entry_started_late;
    public CheckBox scout_required;
    EditText other_comments;
    TextView ok_Btn;
    TextView cancel_Btn;

    public boolean rescout_required_isPressed = false;
    public boolean robot_disabled_isPressed = false;
    public boolean entry_isPressed = false;
    public boolean robot_incapacitated_isPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        robot_disabled = findViewById(R.id.robotDisabled);
        robot_incapacitated = findViewById(R.id.robotIncapacitated);
        entry_started_late = findViewById(R.id.entry_started_late);
        scout_required = findViewById(R.id.scout_required);
        other_comments = findViewById(R.id.edit_comment_txt);
        ok_Btn = findViewById(R.id.ok_Btn);
        cancel_Btn = findViewById(R.id.cancel_Btn);

        robot_disabled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                robot_disabled_isPressed = robot_disabled_isPressed;
            }
        });
        robot_incapacitated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                robot_incapacitated_isPressed = robot_incapacitated_isPressed;
            }
        });

        entry_started_late.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entry_isPressed){
                    entry_isPressed = true;
                    entry_started_late.setBackgroundColor(Color.GREEN);
                }
                else{
                    entry_isPressed = false;
                    entry_started_late.setBackgroundColor(Color.RED);
                }
            }
        });
        scout_required.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (rescout_required_isPressed){
                    rescout_required_isPressed = true;
                    scout_required.setBackgroundColor(Color.GREEN);
                }
                else{
                    rescout_required_isPressed = false;
                    scout_required.setBackgroundColor(Color.RED);
                }
            }
        });

        ok_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAndRemoveTask();
            }
        });
    }
}