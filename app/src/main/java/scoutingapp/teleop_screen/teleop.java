package scoutingapp.teleop_screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.scoutingapp.R;

import scoutingapp.autoscreen.MainActivity;
import scoutingapp.autoscreen.robotHitMiss;
import scoutingapp.endgame.endgame;
import scoutingapp.qr_code;
import scoutingapp.timer;

public class teleop extends MainActivity {

    //creating variables and objects

    public timer timerObj = new timer();
    public MainActivity mainActivityObj=new MainActivity();
    public robotHitMiss robotHitMissObj = new robotHitMiss();


    public Button goToEndgame;
    public Button gotoQRCode;
    private float x1, x2, y1, y2;



    public Intent endgameIntent = new Intent(this, endgame.class);
    public Intent qrCodeIntent = new Intent(this, qr_code.class);

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_screen);

        goToEndgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(endgameIntent);
            }
        });

        gotoQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(qrCodeIntent);
            }
    });

    }
}
