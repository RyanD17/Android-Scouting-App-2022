package scoutingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.scoutingapp.R;

import scoutingapp.autoscreen.MainActivity;

public class select_board extends MainActivity {

    private CheckBox r1;
    private CheckBox r2;
    private CheckBox r3;

    private CheckBox b1;
    private CheckBox b2;
    private CheckBox b3;

    public boolean r1IsPressed = false;
    public boolean r2IsPressed = false;
    public boolean r3IsPressed = false;


    public boolean b1IsPressed = false;
    public boolean b2IsPressed = false;
    public boolean b3IsPressed = false;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_row);

        r1 = findViewById(R.id.red_1);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                r1IsPressed = true;
                r2IsPressed = false;
                r3IsPressed = false;
                b1IsPressed = false;
                b2IsPressed = false;
                b3IsPressed = false;
                r1.setChecked(true);
            }
        });
        r1IsPressed = false;

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                r1IsPressed = false;
                r2IsPressed = true;
                r3IsPressed = false;
                b1IsPressed = false;
                b2IsPressed = false;
                b3IsPressed = false;

            }
        });
        r2IsPressed = false;

        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                r1IsPressed = false;
                r2IsPressed = false;
                r3IsPressed = true;
                b1IsPressed = false;
                b2IsPressed = false;
                b3IsPressed = false;
            }
        });
        r3IsPressed = false;

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                r1IsPressed = false;
                r2IsPressed = false;
                r3IsPressed = false;
                b1IsPressed = true;
                b2IsPressed = false;
                b3IsPressed = false;
            }
        });
        b1IsPressed = false;

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                r1IsPressed = false;
                r2IsPressed = false;
                r3IsPressed = false;
                b1IsPressed = false;
                b2IsPressed = true;
                b3IsPressed = false;
            }
        });
        b2IsPressed = false;

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                r1IsPressed = false;
                r2IsPressed = false;
                r3IsPressed = false;
                b1IsPressed = false;
                b2IsPressed = false;
                b3IsPressed = true;
            }
        });
        b3IsPressed = false;
    }
}