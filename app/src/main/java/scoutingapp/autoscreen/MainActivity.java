package scoutingapp.autoscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.R;

import scoutingapp.CommentActivity;
import scoutingapp.robotHitMiss;
import scoutingapp.teleop_screen.teleop;
import scoutingapp.timer;


public class MainActivity extends AppCompatActivity {

    public ImageButton undoButton;
    public ImageButton commentButton;
    public Button goToTeleop;


    Intent intent = new Intent(this, teleop.class);


    @Override
    protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.auto_screen);



        robotHitMiss robotHitMissObj = new robotHitMiss();
        timer timerObj = new timer();

        //initializing variables
        undoButton = findViewById(R.id.undoButton);
        commentButton = findViewById(R.id.commentBtn);
        goToTeleop = findViewById(R.id.goToTeleop);

        if (timerObj.isTimerButtonPressed) {
            timerObj.startTimer();
        }

        if (timerObj.isPauseButtonPressed) {
            timerObj.pauseTimer();
        }

        if (robotHitMissObj.autoLowMiss_isClicked){
            robotHitMissObj.autoLowMiss_isPressed();
        }

        if (robotHitMissObj.autoLowHit_isClicked){
            robotHitMissObj.autoLowHit_isPressed();
        }

        if (robotHitMissObj.autoHighHit_isClicked){
            robotHitMissObj.autoHighHit_isPressed();
        }
        if (robotHitMissObj.autoHighMiss_isClicked){
            robotHitMissObj.autoHighMiss_isPressed();
        }

        if (robotHitMissObj.LowMiss_isClicked){
            robotHitMissObj.LowMiss_isPressed();
        }

        if (robotHitMissObj.LowHit_isClicked){
            robotHitMissObj.LowHit_isPressed();
        }

        if (robotHitMissObj.HighHit_isClicked){
            robotHitMissObj.autoHighHit_isPressed();
        }
        if (robotHitMissObj.HighMiss_isClicked){
            robotHitMissObj.HighMiss_isPressed();
        }

        commentButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, CommentActivity.class);
            startActivity(intent);
        });

        goToTeleop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(intent);
            }
        });
    }
}