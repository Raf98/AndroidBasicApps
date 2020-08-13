package com.example.calculadoragorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private EditText editValue;
    private TextView textPercentage;
    private SeekBar seekBar;
    private TextView textTip;
    private TextView textTotal;

    private double percentage;
    private double totalValue;
    private double tip;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValue = findViewById(R.id.editValue);
        textPercentage = findViewById(R.id.textPercentage);
        seekBar = findViewById(R.id.seekBar);
        textTip = findViewById(R.id.textTip);
        textTotal = findViewById(R.id.texTotal);

        percentage = 0;
        totalValue = 0;

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if(editValue.getText().toString().equals("") || editValue.getText().toString().equals(".")
                   || editValue.getText().toString() == null)
                {
                    Toast.makeText(getApplicationContext(), "Digite um valor!", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                        percentage = seekBar.getProgress();
                        tip = (percentage*totalValue)/100;
                        totalValue = Double.parseDouble(editValue.getText().toString()) + tip;

                        textPercentage.setText(percentage + "%");
                        textTip.setText( "R$ " + String.format("%.2f", tip) );
                        textTotal.setText( "R$ "+ String.format("%.2f",totalValue) );
                    }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }


}
