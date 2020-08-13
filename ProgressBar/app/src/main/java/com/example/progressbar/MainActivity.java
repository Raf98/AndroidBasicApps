package com.example.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity
{
    private ProgressBar progressBar;
    private ProgressBar progressCycle;
    private Button buttonLoad;
    private int progressRate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressCycle = findViewById(R.id.progressCycle);
        buttonLoad = findViewById(R.id.buttonLoad);

        progressRate = 0;
        progressCycle.setVisibility(View.GONE);
    }

    public void showProgress(View view)
    {
        progressCycle.setVisibility(View.VISIBLE);

        //this.progressRate += 10;

        //progressBar.setProgress(this.progressRate);

        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                for(int i=0; i<=100; i++)
                {
                    final int progress = i;

                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            progressBar.setProgress(progress);

                            if(progress == 100)
                                progressCycle.setVisibility(View.GONE);
                        }
                    });

                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread( runnable ).start();

    }
}
