package com.example.userpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity
{

    private Button buttonSave;
    private TextInputEditText editText;
    private TextView textResult;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSave = findViewById(R.id.buttonSave);
        editText = findViewById(R.id.editText);
        textResult = findViewById(R.id.textResult);

        buttonSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //0(Modo Privado) -> somente este app pode ler e escrever nesse arquivo
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = preferences.edit();

                if(editText.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Preencha o nome", Toast.LENGTH_LONG).show();
                }
                else
                    {
                        String name = editText.getText().toString();
                        editor.putString("nome", name);
                        editor.commit();
                        textResult.setText("Olá " + name);
                    }
            }
        });

        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

        if(preferences.contains("nome"))
        {
            String name = preferences.getString("nome", ", usuário não definido.");
            textResult.setText("Olá " + name);
        }
        else
            {
                textResult.setText("Olá, usuário não definido.");
            }
    }
}
