package com.example.scoutingapp.autoscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import com.example.scoutingapp.CommentActivity;
import com.example.scoutingapp.R;
import com.example.scoutingapp.teleop_screen.teleop;


public class MainActivity<data> extends AppCompatActivity {

    ImageButton commentBtn;
    public ImageButton undoButton;


    public boolean isClicked = false;

    float x1, x2, y1, y2;

    CommentActivity commentActivity = new CommentActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);

        //initializing variables
        undoButton = findViewById(R.id.undoButton);
        commentBtn = findViewById(R.id.commentBtn);

        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCommentActivity();
            }
        });
    }
    public boolean onTouchEvent(MotionEvent touchEvent){
        switch (touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1 < x2){
                    Intent intent = new Intent(MainActivity.this, teleop.class);
                    startActivity(intent);
                }
                break;
        }
        return false;
    }

    public void openCommentActivity() {
        Intent intent = new Intent(this, com.example.scoutingapp.CommentActivity.class);
        startActivity(intent);
    }
}