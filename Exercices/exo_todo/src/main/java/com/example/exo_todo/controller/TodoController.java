package com.example.exo_todo.controller;

import com.example.exo_todo.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/todo1")
    public String todoDetails(Model model){
        Todo todo = Todo.builder().name("Faire une todolist").description("Description de la tache : Faire une todolist").done(false).build();
        model.addAttribute("todo", todo);
        return "todo/todo-details";
    }
}
