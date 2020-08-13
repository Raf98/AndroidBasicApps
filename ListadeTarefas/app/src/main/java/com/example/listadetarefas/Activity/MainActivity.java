package com.example.listadetarefas.Activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.listadetarefas.Adapter.TaskAdapter;
import com.example.listadetarefas.Helper.DBHelper;
import com.example.listadetarefas.Helper.RecyclerItemClickListener;
import com.example.listadetarefas.Helper.TaskDAO;
import com.example.listadetarefas.Model.Task;
import com.example.listadetarefas.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private List<Task> taskList = new ArrayList<>();
    private Task taskSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);

        //loadTaskList();

        /*
        DBHelper db = new DBHelper(getApplicationContext());

        ContentValues cv = new ContentValues();
        cv.put("name", "Teste");

        db.getWritableDatabase().insert("tasks", null, cv);
        */

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener
                        (getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener()
                        {
                            @Override
                            public void onItemClick(View view, int position)
                            {
                                //Log.i("Clique", "OnItemClick");

                                Task taskSelected = taskList.get(position);

                                Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                                intent.putExtra("taskSelected", taskSelected);

                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position)
                            {
                                taskSelected = taskList.get(position);

                                //Log.i("Clique", "OnLongItemClick");
                                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                                dialog.setTitle("Confirmar exclusão");
                                dialog.setMessage("Deseja excluir a a tarefa: " + taskSelected.getTaskName() + " ?");

                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        TaskDAO taskDAO = new TaskDAO(getApplicationContext());

                                        if(taskDAO.delete(taskSelected))
                                        {
                                            loadTaskList();
                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao deletar tarefa!",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                            {
                                                Toast.makeText(getApplicationContext(),
                                                        "Erro ao deletar tarefa!",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                    }
                                });

                                dialog.setNegativeButton("Não", null);

                                dialog.create();
                                dialog.show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                            {

                            }
                        }
                        ));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), AddTaskActivity.class);
                startActivity(intent);
            }
        });
    }

    public void loadTaskList()
    {
        //Listar tarefas
        /*
        Task task1 = new Task();
        task1.setTaskName("Ir ao mercado");
        taskList.add( task1 );

        Task task2 = new Task();
        task2.setTaskName("Ir a feira");
        taskList.add( task2 );
        */
        TaskDAO taskDAO = new TaskDAO(getApplicationContext());
        taskList = taskDAO.list();


        //list<Task>
        //Configurar um adapter
        taskAdapter = new TaskAdapter(taskList);

        //Configurar Recycler View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(taskAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart()
    {
        loadTaskList();
        super.onStart();
    }
}
