package scoutingapp.teleop_screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.R;

import scoutingapp.endgame.endgame;
import scoutingapp.robotHitMiss;

public class teleop extends AppCompatActivity {

    //creating variables and objects

    private robotHitMiss robotHitMissObj = new robotHitMiss();
    public Button goToEndgame;

    public Intent endgameIntent = new Intent(this, endgame.class);

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

        if (robotHitMissObj.HighHit_isClicked) {
            robotHitMissObj.HighHit_isPressed();
        }

    }
}
