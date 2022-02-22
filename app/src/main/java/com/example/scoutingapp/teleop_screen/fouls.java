package com.example.scoutingapp.teleop_screen;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.scoutingapp.R;

public class fouls extends teleop {

    private Button foul;//creating a new button with the name foul
    private TextView foul_counter;

    private Button tech_foul;
    private TextView tech_foul_counter;
    public  int foul_count;
    public int tech_foul_count;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_screen);

        foul = findViewById(R.id.foul);
        foul_counter = findViewById(R.id.foul_count);

        tech_foul = findViewById(R.id.tech_foul);
        tech_foul_counter = findViewById(R.id.tech_foul_count);
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
