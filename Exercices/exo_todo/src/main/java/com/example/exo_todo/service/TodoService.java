package com.example.exo_todo.service;

import com.example.exo_todo.model.Todo;

import java.util.List;

public interface TodoService {

    Todo getTodoById();

    List<Todo> getAllTodo();

}
