package com.example.demo_fragment.controller;

import com.example.demo_fragment.model.Rabbit;
import com.example.demo_fragment.service.RabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private final RabbitService rabbitService;

    @GetMapping("/")
    public String homePage(){
        return "pagea";
    }

    @GetMapping("/pageb")
    public String pageb(Model model) {
        List<Rabbit> rabbits = rabbitService.getRabbits();
        Rabbit rabbit = rabbits.get(0);
        model.addAttribute("rabbitId", rabbit.getId());
        model.addAttribute("rabbits", rabbits);
        return "pageb";
    }

    @GetMapping("/detail/{rabbitId}")
    public String detailRabbit(@PathVariable("rabbitId")UUID id, Model model) {
        Rabbit rabbit = rabbitService.getRabbitById(id);
        model.addAttribute("myRabbit", rabbit);
        return "pagec";
    }

}
