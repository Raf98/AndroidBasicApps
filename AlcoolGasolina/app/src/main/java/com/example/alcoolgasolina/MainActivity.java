package com.example.alcoolgasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private EditText editAlcohol;
    private EditText editGasoline;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcohol = findViewById(R.id.editAlcohol);
        editGasoline = findViewById(R.id.editGasoline);
        textResult = findViewById(R.id.textResult);
    }

    public void calculatePrice(View view)
    {
        String alcohol = editAlcohol.getText().toString();
        String gasoline = editGasoline.getText().toString();

        boolean validEntrys = parseEdit(alcohol, gasoline);

        if( validEntrys )
        {
            Double priceAlcohol = Double.parseDouble(alcohol);
            Double priceGasoline = Double.parseDouble(gasoline);

            Double result = priceAlcohol/priceGasoline;

            if( result >= 0.7 )
                textResult.setText("Melhor utilizar gasolina!");
            else
                textResult.setText("Melhor utilizar álcool!");
        }
        else
            {
                textResult.setText("Preencha os preços primeiro!");
            }

    }

    public boolean parseEdit(String priceAlcohol, String priceGasoline)
    {
        boolean validEdits = true;

        if( priceAlcohol == null || priceAlcohol.equals("") || priceAlcohol.equals(".") ||
            priceGasoline == null || priceGasoline.equals("") || priceGasoline.equals(".") )
        {
            validEdits = false;
        }


        return validEdits;
    }
}
