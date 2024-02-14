package com.example.demo_fragment.controller;

import com.example.demo_fragment.model.Rabbit;
import com.example.demo_fragment.service.RabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/demo")
@RequiredArgsConstructor
public class DemoRestController {

    private final RabbitService rabbitService;

    @GetMapping("/rabbit/{id}")
    public Rabbit getRabbitById(@PathVariable UUID id){
        return rabbitService.getRabbitById(id);
    }

    @GetMapping("/rabbits")
    public List<Rabbit> getAllRabbit(){
        return rabbitService.getRabbits();
    }

    @PostMapping
    public Rabbit createRabbit(@RequestBody Rabbit rabbit){
        rabbitService.addRabbit(rabbit);
        return rabbit;
    }

    @DeleteMapping("/rabbit/{id}")
    public void deleteRabbit(@PathVariable UUID id){
    }

    @PutMapping("/rabbit/{id}")
    public void updateRabbit(@PathVariable UUID id){

    }
}
