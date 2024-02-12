package com.example.exo_todo.controller;

import com.example.exo_todo.model.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/base")
public class TodoRestController {

    @GetMapping("/todo")
    public Todo todo(){
        Todo todo = Todo.builder().name("Creer une todolist").description("Description de la tache : Creer une todolist").done(false).build();

        return todo;
    }

    @GetMapping("/todos")
    public List<Todo> todos(){
        List <Todo> todos = new ArrayList<>();

        todos.add(Todo.builder().name("Creer une todolist").description("Description de la tache : Creer une todolist").done(false).build());
        todos.add(Todo.builder().name("Mettre a jour une todolist").description("Description de la tache : Mettre a jour une todolist").done(true).build());
        todos.add(Todo.builder().name("Supprimer une todolist").description("Description de la tache : Supprimer une todolist").done(true).build());
        todos.add(Todo.builder().name("Lire une todolist").description("Description de la tache : Lire une todolist").done(false).build());

        return todos;
    }

}
