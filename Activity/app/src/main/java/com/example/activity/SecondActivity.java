package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{

    private TextView textName;
    private TextView textAge;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textName = findViewById(R.id.textName);
        textAge = findViewById(R.id.textAge);

        Bundle data = getIntent().getExtras();
        String name = data.getString("name");
        int age = data.getInt("age");
        User user = (User)data.getSerializable("object");

        textName.setText(user.getEmail());
        textAge.setText(String.valueOf(age));
    }
}
