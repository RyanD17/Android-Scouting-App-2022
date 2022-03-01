package scoutingapp.autoscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.R;

import scoutingapp.CommentActivity;
import scoutingapp.teleop_screen.teleop;
import scoutingapp.timer;


public class MainActivity<data> extends AppCompatActivity {

    public ImageButton undoButton;
    public ImageButton commentButton;
    public Button goToTeleop;


    private boolean teleopIsPressed;

    public robotHitMiss robotHitMissObj = new robotHitMiss();
    public timer timerObj = new timer();
    Intent teleopIntent = new Intent(this, teleop.class);

    public void goToTeleop(){
        goToTeleop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(teleopIntent);
            }
        });
    }
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);


        if (teleopIsPressed){
            goToTeleop();
        }

        //initializing variables
        undoButton = findViewById(R.id.undoButton);
        commentButton = findViewById(R.id.commentBtn);
        goToTeleop = findViewById(R.id.goToTeleop);

        while (timerObj.isTimerRunning){
            timerObj.startTimer();
        }

        if (robotHitMissObj.autoLowMiss_isClicked){
            robotHitMissObj.autoLowMiss_isPressed();
        }

        else if (robotHitMissObj.autoLowHit_isClicked){
            robotHitMissObj.autoLowHit_isPressed();
        }

        else if (robotHitMissObj.autoHighHit_isClicked){
            robotHitMissObj.autoHighHit_isPressed();
        }
        else if (robotHitMissObj.autoHighMiss_isClicked){
            robotHitMissObj.autoHighMiss_isPressed();
        }

        else if (robotHitMissObj.LowMiss_isClicked){
            robotHitMissObj.LowMiss_isPressed();
        }

        else if (robotHitMissObj.LowHit_isClicked){
            robotHitMissObj.LowHit_isPressed();
        }

        else if (robotHitMissObj.HighHit_isClicked){
            robotHitMissObj.autoHighHit_isPressed();
        }
        else if (robotHitMissObj.HighMiss_isClicked){
            robotHitMissObj.HighMiss_isPressed();
        }
        commentButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, CommentActivity.class);
            startActivity(intent);
        });
    }
}