package com.example.demo_fragment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Rabbit {
    private UUID id;
    private String name;
    private String breed;

}
