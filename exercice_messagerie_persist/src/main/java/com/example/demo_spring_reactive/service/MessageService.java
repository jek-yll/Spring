package com.example.demo_spring_reactive.service;

import com.example.demo_spring_reactive.dao.MessageDAO;
import com.example.demo_spring_reactive.dto.MessageDTO;
import com.example.demo_spring_reactive.model.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.LocalDateTime;

@Service
public class MessageService {

    private final Sinks.Many<Message> sink;
    public final MessageDAO messageDAO;

    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void sendMessage(String sender, String content) {
        sink.tryEmitNext(Message.builder().content(content).sender(sender).messageDateTime(LocalDateTime.now()).build());
    }

    public Flux<Message> getFlux() {
        return sink.asFlux();
    }


    public void sendMessageBdd(String sender, String content) {
         messageDAO.post(MessageDTO.builder()
                .sender(sender)
                .content(content)
                .build()).then().subscribe();
        sink.tryEmitNext(Message.builder().content(content).sender(sender).messageDateTime(LocalDateTime.now()).build());
    }

    public Flux<MessageDTO> getFluxBdd() {
        return messageDAO.getAll();
        //return sink.asFlux();
    }

}
