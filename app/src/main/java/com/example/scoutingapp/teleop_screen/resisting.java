package com.example.scoutingapp.teleop_screen;

import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.example.scoutingapp.R;

public class resisting extends teleop{

    ToggleButton resisting;

    public boolean resisting_is_clicked =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_screen);

        resisting = findViewById(R.id.risisting);

        //code for making the resisting trench button work
        resisting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resisting_is_clicked = true;
                undoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        });
    }
}
