package org.example.exo2_news_meteo.controller;

import org.example.exo2_news_meteo.model.Meteo;
import org.example.exo2_news_meteo.model.News;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/client")
public class ClientRestController {

    private WebClient webClient;

    public ClientRestController(){
        webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
    }

    @GetMapping
    public Flux<Object> getNewsByCity(){
        Flux<Meteo> fluxMeteo = this.webClient.get().uri("/meteo")
                .retrieve()
                .bodyToFlux(Meteo.class);

        Flux<News> fluxNews = this.webClient.get().uri("/news")
                .retrieve()
                .bodyToFlux(News.class);

        return Flux.zip(fluxMeteo, fluxNews)
                .flatMap(t -> Flux.fromArray(new Object[]{t.getT1(), t.getT2()}));
    }
}
