package com.example.minhasanotaes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private NotesPreferences notesPreferences;
    private EditText editNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNote = findViewById(R.id.editNote);

        notesPreferences = new NotesPreferences(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String editNoteText = editNote.getText().toString();

                if(editNoteText.equals(""))
                {
                    Snackbar.make(v, "Preencha a anotação!", Snackbar.LENGTH_LONG).show();
                }
                else
                    {
                        notesPreferences.saveNote(editNoteText);
                        Snackbar.make(v, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
                    }
            }
        });


        String note = notesPreferences.getNote();

        if(!note.equals(""))
        {
            editNote.setText(note);
        }
    }


}
