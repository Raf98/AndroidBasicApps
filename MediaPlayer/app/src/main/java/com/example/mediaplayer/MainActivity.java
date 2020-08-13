package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private SeekBar seekBarVolume;
    private Button buttonPlay;
    private Button buttonPause;
    private Button buttonStop;
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarVolume = findViewById(R.id.seekBarVolume);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.peace);

        initSeekBar();
    }

    private void initSeekBar()
    {
        //seekBarVolume = findViewById(R.id.seekBarVolume);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int volumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeCurrent = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seekBarVolume.setMax(volumeMax);
        seekBarVolume.setProgress(volumeCurrent);

        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, AudioManager.FLAG_SHOW_UI);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void playSong(View v)
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.start();
        }
    }

    public void pauseSong(View v)
    {
        if(mediaPlayer != null && mediaPlayer.isPlaying())
        {
            mediaPlayer.pause();
        }
    }

    public void stopSong(View v)
    {
        if(mediaPlayer != null && mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.peace);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null && mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        if(mediaPlayer != null && mediaPlayer.isPlaying())
        {
            mediaPlayer.pause();
        }

        Toast.makeText(getApplicationContext(), "Saiu do app Media Player!", Toast.LENGTH_SHORT).show();

    }
}
