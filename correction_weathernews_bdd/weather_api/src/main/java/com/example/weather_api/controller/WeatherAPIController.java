package com.example.weather_api.controller;


import com.example.weather_api.entity.WeatherForecast;
import com.example.weather_api.repository.WeatherRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.Random;

@RequestMapping("weather")
@RestController
public class WeatherAPIController {

    private final Random random;
    private final WeatherRepository weatherRepository;

    public WeatherAPIController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
        random = new Random();
    }

    @GetMapping(value = "{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<WeatherForecast> get(@PathVariable String city) {
        return weatherRepository.searchByCity(city).next();
    }

    @PostMapping
    public Mono<WeatherForecast> post(@RequestBody WeatherForecast weatherForecast) {
        return weatherRepository.save(weatherForecast);
    }
}
