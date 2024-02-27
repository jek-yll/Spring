package com.example.demo_spring_reactive.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
public class Message {

    @Id
    private Long id;
    private String sender;
    private String content;
    private LocalDateTime messageDateTime;
}
