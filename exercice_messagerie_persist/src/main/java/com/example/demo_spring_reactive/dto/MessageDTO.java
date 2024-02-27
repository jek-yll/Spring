package com.example.demo_spring_reactive.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDTO {
    private String content;
    private String sender;

}
