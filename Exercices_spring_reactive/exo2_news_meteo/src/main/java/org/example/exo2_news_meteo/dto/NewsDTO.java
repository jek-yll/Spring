package org.example.exo2_news_meteo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NewsDTO {
    private String content;
    private String city;
    private LocalDate date;
}
