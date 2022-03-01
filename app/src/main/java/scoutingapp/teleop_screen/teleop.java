package scoutingapp.teleop_screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import com.example.scoutingapp.R;

import scoutingapp.autoscreen.MainActivity;
import scoutingapp.autoscreen.robotHitMiss;
import scoutingapp.endgame.endgame;
import scoutingapp.timer;

public class teleop extends MainActivity {

    //creating variables and objects

    public timer timerObj = new timer();
    public MainActivity mainActivityObj=new MainActivity();
    public robotHitMiss robotHitMissObj = new robotHitMiss();

    private float x1, x2, y1, y2;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_screen);

    }

    public boolean onTouchEvent (MotionEvent touchEvent) {
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1=touchEvent.getX();
                y1=touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2=touchEvent.getX();
                y2=touchEvent.getY();
                if (x1 < x2) {
                    Intent intent = new Intent(teleop.this, endgame.class);
                    startActivity(intent);
                }
                else if (x2 >  x1){
                    Intent intent = new Intent(teleop.this, MainActivity.class);
                    startActivity(intent);
                }
                break;
        }
        return false;
    }
}
