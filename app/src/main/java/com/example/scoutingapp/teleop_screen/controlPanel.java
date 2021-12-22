package com.example.scoutingapp.teleop_screen;

import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.example.scoutingapp.R;

public class controlPanel extends teleop {
    ToggleButton controlPanel;

    public boolean control_panel_is_clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_screen);
        controlPanel = findViewById(R.id.control_panel);

        //code for making the alliance trench button work
        controlPanel.setOnClickListener(new View.OnClickListener() { //I call the onClickListener function
            public void onClick(View v) {//if the alliance trench button is clicked, then this executes
                control_panel_is_clicked = true;
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        });
    }
}
