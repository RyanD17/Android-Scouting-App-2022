package com.example.scoutingapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp.autoscreen.MainActivity;
import com.example.scoutingapp.endgame.endgame;
import com.example.scoutingapp.teleop_screen.teleop;



public class qr_code extends AppCompatActivity {

    private static final String FILENAME_OBJ = "objective_data.csv";
    private static final String LOG_TAG = qr_code.class.getSimpleName();
    Bitmap bitmap;
    Button goToEndgame;
    public final MainActivity MainActivityObj = new MainActivity();
    public final teleop teleopObj = new teleop();

    public final select_board select_boardObj = new select_board();
    public final CommentActivity commentActivityObj = new CommentActivity();
    public endgame endgameObj = new endgame();
    public matchRow matchRowObj = new matchRow();

    public qr_code() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        Button generateQrBtn = findViewById(R.id.generateQR);
        ImageView qrCodeIV=findViewById(R.id.qrCode);
        goToEndgame = findViewById(R.id.goToEndgame);


        goToEndgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent endgameIntent = new Intent(qr_code.this, endgame.class);
                startActivity(endgameIntent);
            }
        });

        generateQrBtn.setOnClickListener(v -> {
            generateCSV();
            generateQRCode();
        });
    }

    private void generateQRCode () {
    }

    private void generateCSV () {

    }
}