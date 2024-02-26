package com.example.exo_todo.controller;

import com.example.exo_todo.model.Todo;
import com.example.exo_todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/base")
public class TodoRestController {

    private final TodoService todoService;

    @Autowired
    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo")
    public Todo todo(){
        return todoService.getTodoById();
    }

    @GetMapping("/todos")
    public List<Todo> todos(){
        return todoService.getAllTodo();
    }

}
