package com.example.componentesbasicos;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private TextInputEditText productName;
    private TextView result;
    private CheckBox checkWhite;
    private CheckBox checkGreen;
    private CheckBox checkRed;
    private List<String> listCheck;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productName = findViewById(R.id.editTextProductName);
        result = findViewById(R.id.textViewResult);
        listCheck = new ArrayList<String>();
        checkWhite = findViewById(R.id.checkWhite);
        checkGreen = findViewById(R.id.checkGreen);
        checkRed = findViewById(R.id.checkRed);
        radioGroup = findViewById(R.id.radioGroup);

        verifyRadioButton();
    }

    public void verifyCheck()
    {
        listCheck.clear();

        if( checkWhite.isChecked()) listCheck.add( checkWhite.getText().toString() );
        if( checkGreen.isChecked()) listCheck.add( checkGreen.getText().toString() );
        if( checkRed.isChecked()) listCheck.add( checkRed.getText().toString() );

        result.setText(listCheck.toString());
    }

    public void verifyRadioButton()
    {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if( checkedId == R.id.radioYes )
                    result.setText("Sim");
                else
                    result.setText("Não");
            }
        });
    }

    public void buttonSend(View view)
    {
        //result.setText(productName.getText().toString());
        //verifyCheck();
        //verifyRadioButton();
    }
}
