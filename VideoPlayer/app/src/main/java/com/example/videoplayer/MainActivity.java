package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity
{
    private ImageView imagePlay;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagePlay = findViewById(R.id.imagePlay);
    }

    public void playVideo(View v)
    {
        startActivity(new Intent(this, PlayerActivity.class));
    }
}
