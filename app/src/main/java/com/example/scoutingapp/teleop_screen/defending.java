package com.example.scoutingapp.teleop_screen;

import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.example.scoutingapp.R;

public class defending extends teleop {
    ToggleButton defending;

    public boolean defending_is_clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_screen);

        defending = findViewById(R.id.defending);

        //code for making the rendezvousObj button work
        defending.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                defending_is_clicked = true;
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        });

    }
}
