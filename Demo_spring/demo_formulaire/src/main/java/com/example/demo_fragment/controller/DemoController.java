package com.example.demo_fragment.controller;

import com.example.demo_fragment.model.Rabbit;
import com.example.demo_fragment.service.RabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/add")
    public String addRabbit(Model model){
        model.addAttribute("rabbit", new Rabbit());
        return "/form/form";
    }

    @PostMapping("/add")
    public String submitRabbit(@ModelAttribute("rabbit")Rabbit rabbit){
        System.out.println(rabbit.getName());
        System.out.println(rabbit.getBreed());
        rabbitService.addRabbit(rabbit.getName(), rabbit.getBreed());
        return "redirect:/";
    }
    @GetMapping("/addRabbit")
    public String submitRabbitV2(@RequestParam("name")String name, @RequestParam("breed")String breed ){
        rabbitService.addRabbit(name, breed);
        return "redirect:/";
    }

    @GetMapping("/look")
    public String showRabbit(@RequestParam(value = "name", required = false)String name, Model model){
        // System.out.println(name);
        Rabbit rabbit = rabbitService.getRabbitByName(name);

        if (rabbit != null){
        model.addAttribute("myRabbit", rabbit);
        return "pagec";
        } else {
            return "paged";
        }
    }
}
