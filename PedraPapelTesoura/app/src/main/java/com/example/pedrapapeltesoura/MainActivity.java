package com.example.pedrapapeltesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectRock(View v)
    {
        this.optionSelected( "rock" );
    }

    public void selectPaper(View v)
    {
        this.optionSelected( "paper" );
    }

    public void selectScissor(View v)
    {
        this.optionSelected( "scissor" );
    }

    public void optionSelected(String userSelection)
    {

        TextView textResult = findViewById(R.id.textResult);
        ImageView imageResult = findViewById(R.id.imageResult);

        ArrayList<String> optionsList = new ArrayList<String>();

        optionsList.add( "rock" );
        optionsList.add( "paper" );
        optionsList.add(  "scissor" );

        String machineSelection = optionsList.get( new Random().nextInt( optionsList.size() ) );
        String result;
        int image;

        result = "";
        image = R.drawable.padrao;

        if( userSelection.equals( machineSelection ) )
        {
            result = "Empate!";

            if(machineSelection.equals("rock")) image = R.drawable.pedra;
            if(machineSelection.equals("paper")) image = R.drawable.papel;
            if(machineSelection.equals("scissor")) image = R.drawable.tesoura;

        }
        else if(userSelection.equals("rock") && machineSelection.equals("paper"))
        {
            result = "Você perdeu.";
            image = R.drawable.papel;
        }
        else if(userSelection.equals("rock") && machineSelection.equals("scissor"))
        {
            result = "Você ganhou!";
            image = R.drawable.tesoura;
        }
        else if(userSelection.equals("paper") && machineSelection.equals("rock"))
        {
            result = "Você ganhou!";
            image = R.drawable.pedra;
        }
        else if(userSelection.equals("paper") && machineSelection.equals("scissor"))
        {
            result = "Você perdeu.";
            image = R.drawable.tesoura;
        }
        else if(userSelection.equals("scissor") && machineSelection.equals("rock"))
        {
            result = "Você perdeu.";
            image = R.drawable.pedra;
        }
        else if(userSelection.equals("scissor") && machineSelection.equals("paper"))
        {
            result = "Você ganhou!";
            image = R.drawable.papel;
        }

        textResult.setText( result );
        imageResult.setImageResource( image );

    }


}
