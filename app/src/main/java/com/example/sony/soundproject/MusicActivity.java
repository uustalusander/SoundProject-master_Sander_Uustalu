package com.example.sony.soundproject;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MusicActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
    }
    public void onMusicPlay (View view) {
        if(mediaPlayer == null)
            mediaPlayer = MediaPlayer.create(this, R.raw.tsirkus);
        mediaPlayer.start();
    }
    public void onMusicPause (View view){
        mediaPlayer.pause();
    }
    public void onMusicStop (View view){
        mediaPlayer.stop();
        mediaPlayer=null;
    }
}
