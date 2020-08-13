package com.example.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
    }

    public void openToast(View view)
    {
        //Toast.makeText(getApplicationContext(), "Botão pressionado", Toast.LENGTH_LONG).show();
        ImageView img = new ImageView(getApplicationContext());
        img.setImageResource(android.R.drawable.star_big_off);


        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(img);
        toast.show();

    }
}
