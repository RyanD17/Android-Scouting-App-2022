package scoutingapp;

import android.os.Bundle;
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

    private final timer timerObj = new timer();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_row);

        r1 = findViewById(R.id.red_1);

        r1.setOnClickListener(v -> {

        });
    }
}