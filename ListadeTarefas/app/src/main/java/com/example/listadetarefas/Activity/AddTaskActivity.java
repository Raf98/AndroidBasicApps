package com.example.listadetarefas.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.listadetarefas.Helper.TaskDAO;
import com.example.listadetarefas.Model.Task;
import com.example.listadetarefas.R;
import com.google.android.material.textfield.TextInputEditText;

public class AddTaskActivity extends AppCompatActivity
{
    private TextInputEditText editTask;
    private Task currentTask;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editTask = findViewById(R.id.textTask);

        currentTask = (Task) getIntent().getSerializableExtra("taskSelected");

        if(currentTask != null)
        {
            editTask.setText(currentTask.getTaskName());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_add_task, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.itemSave:

                TaskDAO taskDAO = new TaskDAO(getApplicationContext());

                if(currentTask != null)     //ediçao
                {
                    String taskName = editTask.getText().toString();

                    if(!taskName.isEmpty())
                    {
                        Task task = new Task();
                        task.setTaskName(taskName);
                        task.setId(currentTask.getId());

                        if(taskDAO.update(task))
                        {
                            finish();
                            Toast.makeText(getApplicationContext(),
                                    "Sucesso ao atualizar tarefa!",
                                    Toast.LENGTH_SHORT).show();

                        }
                        else
                            {
                                Toast.makeText(getApplicationContext(),
                                        "Erro ao atualizar tarefa!",
                                        Toast.LENGTH_SHORT).show();
                            }
                    }
                }
                else                        //salvar
                    {

                        String taskName = editTask.getText().toString();

                        if(!taskName.isEmpty())
                        {
                            Task task = new Task();
                            task.setTaskName(taskName);
                            //task.setTaskName("Ir ao mercado");
                            if(taskDAO.save(task))
                            {
                                finish();
                                Toast.makeText(getApplicationContext(),
                                                "Sucesso ao salvar tarefa!",
                                                Toast.LENGTH_SHORT).show();
                            }
                            else
                                {
                                    Toast.makeText(getApplicationContext(),
                                            "Erro ao salvar tarefa!",
                                            Toast.LENGTH_SHORT).show();
                                }

                        }
                    }


                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
