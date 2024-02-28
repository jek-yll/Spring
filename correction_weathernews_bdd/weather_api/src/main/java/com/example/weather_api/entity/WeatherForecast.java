package com.example.weather_api.entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "weather")
public class WeatherForecast {

    @Id

    private String id;
    private String city;
    private double temperature;
}
