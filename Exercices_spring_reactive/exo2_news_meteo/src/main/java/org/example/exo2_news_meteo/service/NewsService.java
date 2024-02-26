package org.example.exo2_news_meteo.service;

import org.example.exo2_news_meteo.model.News;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class NewsService {

    private final Sinks.Many<News> sink;


    public NewsService( ) {
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void sendNews(String content, String city){
        News news = News.builder()
                .content(content)
                .date(LocalDate.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                .city(city)
                .build();
        sink.tryEmitNext(news);
    }

    public Flux<News> getNews(){
        return sink.asFlux();
    }
}
