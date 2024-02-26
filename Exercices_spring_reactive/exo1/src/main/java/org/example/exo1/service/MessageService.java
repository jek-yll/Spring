package org.example.exo1.service;

import org.example.exo1.model.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class MessageService {

    private final Sinks.Many<Message> sink;

    public MessageService(){
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void sendMessage(Message message){
        sink.tryEmitNext(message);
    }

    public Flux<Message> getMessage(){
        //String content = message.getContent();
        return sink.asFlux();
    }
}
