package scoutingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.R;

import scoutingapp.autoscreen.MainActivity;
import scoutingapp.autoscreen.robotHitMiss;
import scoutingapp.teleop_screen.defending;
import scoutingapp.teleop_screen.fouls;

public class qr_code extends AppCompatActivity {

    ImageView qr_code;
    Button generateCode;
    public final MainActivity mainActivityObj = new MainActivity();
    public final robotHitMiss robotHitMissObj = new robotHitMiss();
    public defending defendingObj = new defending();
    public final fouls foulsObj = new fouls();
    public final select_board select_boardObj = new select_board();
    public final CommentActivity commentActivityObj = new CommentActivity();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        qr_code=findViewById(R.id.QRCode);
        generateCode=findViewById(R.id.generateCode);


        SharedPreferences sp;

        sp=getSharedPreferences("My Shared Prefs", Context.MODE_PRIVATE);

        generateCode.setOnClickListener(v -> {


            SharedPreferences.Editor autoHighHitEditor=sp.edit();
            autoHighHitEditor.putString("number", String.valueOf(robotHitMissObj.autoHighHitCount));

            SharedPreferences.Editor autoLowHitEditor=sp.edit();
            autoLowHitEditor.putString("number", String.valueOf(robotHitMissObj.autoLowHitCount));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor autoHighMissEditor=sp.edit();
            autoHighMissEditor.putString("number", String.valueOf(robotHitMissObj.autoHighMissCount));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor autoLowMissEditor=sp.edit();
            autoLowMissEditor.putString("number", String.valueOf(robotHitMissObj.autoLowMissCount));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor defenseTimeEditor=sp.edit();
            defenseTimeEditor.putString("number", String.valueOf(defendingObj.defense_time));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor foulsEditor=sp.edit();
            foulsEditor.putString("number", String.valueOf(foulsObj.foul_count));

            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor tech_foulEditor=sp.edit();
            tech_foulEditor.putString("number", String.valueOf(foulsObj.tech_foul_count));

            SharedPreferences.Editor boardEditor=sp.edit();
            boardEditor.putString("r1", String.valueOf(select_boardObj.r1IsPressed));
            boardEditor.putString("r2", String.valueOf(select_boardObj.r2IsPressed));
            boardEditor.putString("r3", String.valueOf(select_boardObj.r3IsPressed));

            boardEditor.putString("b1", String.valueOf(select_boardObj.b1IsPressed));
            boardEditor.putString("b2", String.valueOf(select_boardObj.b2IsPressed));
            boardEditor.putString("b3", String.valueOf(select_boardObj.b3IsPressed));

            SharedPreferences.Editor defendingEditor=sp.edit();
            defendingEditor.putString("time defended", String.valueOf(defendingObj.defense_time));

            commentActivityObj.robotDisabledEditor.putString("is Pressed", String.valueOf(commentActivityObj.robot_disabled_isPressed));
            commentActivityObj.robotIncapacitatedEditor.putString("is Pressed", String.valueOf(commentActivityObj.robot_incapacitated_isPressed));
            commentActivityObj.entryStaredLateEditor.putString("is Pressed", String.valueOf(commentActivityObj.entry_isPressed));
            commentActivityObj.reScoutRequiredEditor.putString("is Pressed", String.valueOf(commentActivityObj.rescout_required_isPressed));




            
        });
    }
}