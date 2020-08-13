package com.example.listadetarefas.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CpuUsageInfo;
import android.util.Log;

import com.example.listadetarefas.Model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO implements ITarefaDAO
{
    private SQLiteDatabase write;
    private SQLiteDatabase read;

    public TaskDAO(Context context)
    {
        DBHelper db = new DBHelper(context);
        write = db.getWritableDatabase();
        read = db.getReadableDatabase();
    }

    @Override
    public boolean save(Task task)
    {
        ContentValues cv = new ContentValues();
        cv.put("name", task.getTaskName());

        try
        {
            write.insert(DBHelper.TABLE_TASKS, null, cv);
            Log.i("INFO", "Tarefa salva com sucesso!");
        }
        catch (Exception e)
        {
            Log.e("INFO", "Erro ao salvar tarefa " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean update(Task task)
    {
        ContentValues cv = new ContentValues();
        cv.put("name", task.getTaskName());

        try
        {
            String[] args = {task.getId().toString()};
            write.update(DBHelper.TABLE_TASKS, cv, "id = ?", args);
            Log.i("INFO", "Tarefa atualizada com sucesso!");
        }
        catch (Exception e)
        {
            Log.e("INFO", "Erro ao atualizar tarefa " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(Task task)
    {
        try
        {
            String[] args = {task.getId().toString()};
            write.delete(DBHelper.TABLE_TASKS, "id = ?", args);
            Log.i("INFO", "Tarefa removida com sucesso!");
        }
        catch (Exception e)
        {
            Log.e("INFO", "Erro ao remover tarefa " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public List<Task> list()
    {
        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT * FROM  " + DBHelper.TABLE_TASKS + " ;";
        Cursor cursor = read.rawQuery(sql, null);

        //cursor.moveToFirst();

        while (cursor.moveToNext())
        {
            Task task = new Task();

            Long id = cursor.getLong(cursor.getColumnIndex("id"));
            String taskName = cursor.getString(cursor.getColumnIndex("name"));

            task.setId(id);
            task.setTaskName(taskName);

            tasks.add(task);
        }

        return tasks;
    }
}
