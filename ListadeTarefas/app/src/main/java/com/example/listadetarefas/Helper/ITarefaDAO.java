package com.example.listadetarefas.Helper;

import com.example.listadetarefas.Model.Task;

import java.util.List;

public interface ITarefaDAO
{
    public boolean save(Task task);
    public boolean update(Task task);
    public boolean delete(Task task);
    public List<Task> list();
}
