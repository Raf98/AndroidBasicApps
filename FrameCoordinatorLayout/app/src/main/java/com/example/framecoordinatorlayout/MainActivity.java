package com.example.framecoordinatorlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //frameLayout = findViewById(R.id.frameLoading);
        //frameLayout.setVisibility(View.GONE);

    }

/*    public void open(View view)
    {
        frameLayout.setVisibility(View.VISIBLE);
    }*/
}
