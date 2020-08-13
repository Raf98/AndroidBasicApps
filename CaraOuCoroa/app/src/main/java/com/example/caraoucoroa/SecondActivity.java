package com.example.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity
{

    private Button buttonBack;
    private ImageView imageResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttonBack = findViewById(R.id.buttonBack);
        imageResult = findViewById(R.id.imageCoin);

        Bundle data = getIntent().getExtras();
        int number = data.getInt("number");

        if(number == 0)
        {
            imageResult.setImageResource(R.drawable.moeda_cara);
        }
        else
            {
                imageResult.setImageResource(R.drawable.moeda_coroa);
            }

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}
