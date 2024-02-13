package com.example.demo_fragment.service;

import com.example.demo_fragment.model.Rabbit;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class RabbitService {

    private final Map<UUID, Rabbit> rabbits;

    public RabbitService() {
        this.rabbits = new HashMap<>();

        Rabbit rabbitA = Rabbit.builder()
                .id(UUID.randomUUID())
                .name("bugs bunny")
                .breed("angora")
                .build();
        Rabbit rabbitB = Rabbit.builder()
                .id(UUID.randomUUID())
                .name("lola bunny")
                .breed("bélier")
                .build();
        Rabbit rabbitC = Rabbit.builder()
                .id(UUID.randomUUID())
                .name("roger rabbit")
                .breed("jersey wooly")
                .build();

        rabbits.put(rabbitA.getId(), rabbitA);
        rabbits.put(rabbitB.getId(), rabbitB);
        rabbits.put(rabbitC.getId(), rabbitC);
    }

    public List<Rabbit> getRabbits(){
        return rabbits.values().stream().toList();
    }

    public Rabbit getRabbitById(UUID id) {
        return rabbits.get(id);
        // return rabbits.values().stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }

    public Rabbit getRabbitByName(String name){
        return  rabbits.values().stream().filter(r -> r.getName().equals(name)).findFirst().orElse(null);
    }

    public Boolean addRabbit(String name, String breed){
        Rabbit rabbit = Rabbit.builder()
                .id(UUID.randomUUID())
                .name(name)
                .breed(breed)
                .build();
        rabbits.put(rabbit.getId(), rabbit);
        return true;
    }

}
