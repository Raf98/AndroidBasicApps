package com.example.frasesdodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeSentence(View view)
    {
        TextView sentence = findViewById(R.id.textSentence);

        ArrayList<String> sentencesList = new ArrayList<String>();

        sentencesList.add("I am your father!");
        sentencesList.add("With great power comes great responsibility");
        sentencesList.add("Criminals are a superstitious cowardly lot.");
        sentencesList.add("Avengers assemble!");

        sentence.setText( sentencesList.get(new Random().nextInt( sentencesList.size() )) );

    }
}
