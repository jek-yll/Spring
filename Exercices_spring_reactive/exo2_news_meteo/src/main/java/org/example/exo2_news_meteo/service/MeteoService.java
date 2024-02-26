package org.example.exo2_news_meteo.service;

import org.example.exo2_news_meteo.model.Meteo;
import org.example.exo2_news_meteo.model.News;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MeteoService {

    private final Sinks.Many<Meteo> sink;


    public MeteoService() {
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void sendMeteo(String city, int temp){
        Meteo meteo = Meteo.builder()
                .city(city)
                .temp(temp)
                .date(LocalDate.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                .build();
        sink.tryEmitNext(meteo);
    }

    public Flux<Meteo> getMeteo(){
        return sink.asFlux();
    }

}
