package org.example.exo1.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {

    private String content;
    private String user;
}
