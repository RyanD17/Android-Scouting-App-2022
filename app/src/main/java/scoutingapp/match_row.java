package scoutingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;


import com.example.scoutingapp.R;

import scoutingapp.autoscreen.MainActivity;

public class match_row extends MainActivity {

    private CheckBox r1;

    public boolean isR1Pressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_row);


        r1=findViewById(R.id.red_1);

        r1.setOnClickListener(v -> {
            isR1Pressed = true;
            Intent intent=new Intent(this, select_board.class);
            startActivity(intent);
        });
        isR1Pressed = false;
    }
}
