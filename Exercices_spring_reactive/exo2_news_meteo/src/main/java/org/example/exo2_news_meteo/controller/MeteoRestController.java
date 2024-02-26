package org.example.exo2_news_meteo.controller;

import org.example.exo2_news_meteo.dto.MeteoDTO;
import org.example.exo2_news_meteo.model.Meteo;
import org.example.exo2_news_meteo.service.MeteoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/meteo")
public class MeteoRestController {
    private final MeteoService meteoService;

    public MeteoRestController(MeteoService meteoService) {
        this.meteoService = meteoService;
    }


    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Meteo> get(){
        return meteoService.getMeteo();
    }

    @PostMapping
    public void post(@RequestBody MeteoDTO meteoDTO){
        meteoService.sendMeteo(meteoDTO.getCity(), meteoDTO.getTemp());
    }

}
