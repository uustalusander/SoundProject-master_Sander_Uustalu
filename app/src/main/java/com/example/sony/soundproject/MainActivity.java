package com.example.sony.soundproject;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.CheckBox;
import android.content.Intent;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    TextView txt6, txt7;
    CheckBox checkBox;
    ToggleButton toggleButton;
    Button watchVideo;
    RadioButton radioButton;
    //MediaPlayer class ca be used to control playback of audio/video files
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt6 = (TextView) findViewById(R.id.textView6);
        txt7 = (TextView) findViewById(R.id.textView7);
        checkBox = (CheckBox) findViewById(R.id.CheckBawx);
        toggleButton = (ToggleButton) findViewById(R.id.ToggleBut);
        radioButton = (RadioButton) findViewById(R.id.RadioBut);
        watchVideo = (Button) findViewById(R.id.But);
        //Nupp ei ole aktiivne
        watchVideo.setEnabled(false);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.sugarplumfairydance);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        CompoundButton.OnCheckedChangeListener checker = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
                if (checkBox.isChecked()) {
                    watchVideo.setEnabled(true);
                } else if (watchVideo.isEnabled()) {
                    watchVideo.setEnabled(false);
                }
            }
        };
        checkBox.setOnCheckedChangeListener(checker);
        watchVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                startActivity(intent);
                mediaPlayer.stop();
            }
        });
    };
    public void onToggle(View view){
        if (toggleButton.isChecked()){
            mediaPlayer.stop();
            txt6.setText("Music is off");
        }else{
            txt6.setText("Music is gone");
        }
    }
        public void onRadio(View view){
        if (radioButton.isChecked())
            txt7.setText("You pushed button");
        else;
    }
}

