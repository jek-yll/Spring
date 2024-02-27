package com.example.demo_spring_reactive.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Message {
    private String sender;
    private String content;
    private LocalDateTime messageDateTime;
}
