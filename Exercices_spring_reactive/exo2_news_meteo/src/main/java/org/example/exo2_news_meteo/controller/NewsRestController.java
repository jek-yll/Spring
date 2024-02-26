package org.example.exo2_news_meteo.controller;

import org.example.exo2_news_meteo.dto.NewsDTO;
import org.example.exo2_news_meteo.model.News;
import org.example.exo2_news_meteo.service.NewsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/news")
public class NewsRestController {

    private final NewsService newsService;

    public NewsRestController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<News> get(){
        return newsService.getNews();
    }

    @PostMapping
    public void post(@RequestBody NewsDTO newsDTO){
        newsService.sendNews(newsDTO.getContent(), newsDTO.getCity());
    }
}

