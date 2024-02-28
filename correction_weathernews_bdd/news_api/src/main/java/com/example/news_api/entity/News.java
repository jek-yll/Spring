package com.example.news_api.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class News {

    @Id
    private int id;
    private String city;
    private String content;
    private LocalDateTime dateTime;
}
