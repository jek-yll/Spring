package com.example.demo_spring_reactive.service;

import com.example.demo_spring_reactive.model.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.LocalDateTime;

@Service
public class MessageService {

    private final Sinks.Many<Message> sink;

    public MessageService() {
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void sendMessage(String sender, String content) {
        sink.tryEmitNext(Message.builder().content(content).sender(sender).messageDateTime(LocalDateTime.now()).build());
    }

    public Flux<Message> getFlux() {
        return sink.asFlux();
    }
}
