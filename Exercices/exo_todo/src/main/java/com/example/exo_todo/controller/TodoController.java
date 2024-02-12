package com.example.exo_todo.controller;

import com.example.exo_todo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/todo1")
    public String todoDetails(Model model){
        model.addAttribute("todo", todoService.todosList().get(1));
        return "todo/todo-details";
    }
}
