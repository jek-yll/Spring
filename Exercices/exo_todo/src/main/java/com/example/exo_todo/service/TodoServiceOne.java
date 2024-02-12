package com.example.exo_todo.service;

import com.example.exo_todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceOne implements TodoService {
    @Override
    public Todo getTodoById() {
        Todo todo = Todo.builder().name("Créer une todolist").description("description de Créer une todolist").done(true).build();

        return todo;
    }

    @Override
    public List<Todo> getAllTodo() {
        List<Todo> todos = new ArrayList<>();

        todos.add(Todo.builder().name("Créer une todolist").description("description de Créer une todolist").done(true).build());
        todos.add(Todo.builder().name("Mettre à jour une todolist").description("description de Mettre à jour une todolist").done(true).build());
        todos.add(Todo.builder().name("Lire une todolist").description("description de Lire une todolist").done(true).build());
        todos.add(Todo.builder().name("Supprimer une todolist").description("description de Supprimer une todolist").done(true).build());

        return todos;
    }
}
