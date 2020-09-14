package com.example.componentes2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity
{
    private Switch switchState;
    private ToggleButton toggleState;
    private CheckBox checkState;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchState = findViewById(R.id.switchState);
        toggleState = findViewById(R.id.toggleState);
        checkState = findViewById(R.id.checkState);
        textResult = findViewById(R.id.textResult);

    }


    public void send(View view)
    {
        if(toggleState.isChecked())
        {
            textResult.setText("Toggle ligado");
        }
        else
            textResult.setText("Toggle desligado");
    }
}
