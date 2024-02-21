package org.example.exo1_spring_data_rest.config;

import org.example.exo1_spring_data_rest.eventHandler.CandiesEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    CandiesEventHandler candiesEventHandler(){
        return new CandiesEventHandler();
    }
}
