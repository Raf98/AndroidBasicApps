package com.example.minhasanotaes;

import android.content.Context;
import android.content.SharedPreferences;

public class NotesPreferences
{
    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String FILENAME = "note.preferences";
    private final String KEYNAME = "name";

    public NotesPreferences(Context context)
    {
        this.context = context;
        preferences = context.getSharedPreferences(FILENAME, 0);

        editor = preferences.edit();
    }

    public void saveNote(String note)
    {
        editor.putString(KEYNAME, note);
        editor.commit();
    }

    public String getNote()
    {
        return preferences.getString(KEYNAME, "");
    }
}
