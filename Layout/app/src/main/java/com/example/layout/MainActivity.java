package com.example.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

    public void changeColorBackground(View view)
    {
        //View v = findViewById(R.id.mainBackground);
        Button b = findViewById(R.id.button);
        Button b2 = findViewById(R.id.button2);

        ArrayList<Integer> dr = new ArrayList<Integer>();

        dr.add(R.color.colorAccent);
        dr.add(R.color.colorBackground);
        dr.add(R.color.colorBackgroundButton);
        dr.add(R.color.colorPrimary);
        dr.add(R.color.colorPrimaryDark);

        b.setBackgroundColor( dr.get( new Random().nextInt( dr.size() ) ) );
        b2.setBackgroundColor( dr.get( new Random().nextInt( dr.size() ) ) );
        //v.setBackgroundColor( dr.get( 2/*new Random().nextInt( dr.size() )*/ ) );
    }

}
