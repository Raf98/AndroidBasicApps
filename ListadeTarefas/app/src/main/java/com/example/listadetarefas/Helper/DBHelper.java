package com.example.listadetarefas.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{
    public static int VERSION = 2;
    public static String DB_NAME = "TASKS_DB";
    public static String TABLE_TASKS = "tasks";


    public DBHelper(@Nullable Context context)
    {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_TASKS
                     + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                     + "name TEXT NOT NULL); ";

        try
        {
            db.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao criar tabela");
        }catch (Exception e)
        {
            Log.i("INFO DB" , e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String sql = "DROP TABLE IF EXISTS " + TABLE_TASKS + " ;";

        try
        {
            db.execSQL(sql);
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar app");
        }catch (Exception e)
        {
            Log.i("INFO DB" , "Erro ao atualizar app "+ e.getMessage());
        }
    }
}
