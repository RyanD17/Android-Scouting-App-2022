package scoutingapp;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.R;

public class CommentActivity extends AppCompatActivity {

    CheckBox robot_disabled;
    CheckBox robot_incapacitated;
    CheckBox entry_started_late;
    CheckBox scout_required;
    EditText other_comments;
    TextView ok_Btn;
    TextView cancel_Btn;

    public boolean rescout_required_isPressed = false;
    public boolean robot_disabled_isPressed = false;
    public boolean entry_isPressed = false;
    public boolean robot_incapacitated_isPressed = false;

    public SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        robot_disabled = findViewById(R.id.robotDisabled);
        robot_incapacitated = findViewById(R.id.robotIncapacitated);
        entry_started_late = findViewById(R.id.entry_started_late);
        scout_required = findViewById(R.id.scout_required);
        other_comments = findViewById(R.id.edit_comment_txt);
        ok_Btn = findViewById(R.id.ok_Btn);
        cancel_Btn = findViewById(R.id.cancel_Btn);


        robot_disabled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                robot_disabled_isPressed = true;
                robot_disabled.setBackgroundColor(Color.GREEN);
            }
        });
        robot_disabled_isPressed = false;
        robot_disabled.setBackgroundColor(Color.RED);

        robot_incapacitated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                robot_incapacitated_isPressed = true;
                robot_incapacitated.setBackgroundColor(Color.GREEN);
            }
        });
        robot_incapacitated_isPressed = false;
        robot_incapacitated.setBackgroundColor(Color.RED);

        entry_started_late.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entry_isPressed){
                    entry_isPressed = true;
                    entry_started_late.setBackgroundColor(Color.GREEN);
                }
                else{
                    entry_isPressed = false;
                    entry_started_late.setBackgroundColor(Color.RED);
                }
            }
        });
        scout_required.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rescout_required_isPressed){
                    rescout_required_isPressed = true;
                    scout_required.setBackgroundColor(Color.GREEN);
                }
                else{
                    rescout_required_isPressed = false;
                    scout_required.setBackgroundColor(Color.RED);
                }
            }
        });

        cancel_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                finishAndRemoveTask();
            }
        });

        ok_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert (sp != null);
                SharedPreferences.Editor robotDisabledEditor = sp.edit();
                SharedPreferences.Editor robotIncapacitatedEditor = sp.edit();
                SharedPreferences.Editor entryStaredLateEditor = sp.edit();
                SharedPreferences.Editor reScoutRequiredEditor = sp.edit();

                robotDisabledEditor.putString("is Pressed", String.valueOf(robot_disabled_isPressed));
                robotIncapacitatedEditor.putString("is Pressed", String.valueOf(robot_incapacitated_isPressed));
                entryStaredLateEditor.putString("is Pressed", String.valueOf(entry_isPressed));
                reScoutRequiredEditor.putString("Is Pressed", String.valueOf(rescout_required_isPressed));
                robotDisabledEditor.apply();;
                robotIncapacitatedEditor.apply();
                entryStaredLateEditor.apply();
                reScoutRequiredEditor.apply();

                finishAndRemoveTask();


                }
        });
    }
}