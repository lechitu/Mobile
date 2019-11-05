package com.lechitu.musicservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import static com.lechitu.musicservice.R.raw.hoangmang;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button play;
    Button stop;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.startBtn);
        stop = findViewById(R.id.stopBtn);
        play.setOnClickListener(this);
        stop.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == play){
//            player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
            startService(new Intent(this, PlayerService.class));
        }
        else if (v == stop){
            stopService(new Intent(this, PlayerService.class));
        }
    }
}
