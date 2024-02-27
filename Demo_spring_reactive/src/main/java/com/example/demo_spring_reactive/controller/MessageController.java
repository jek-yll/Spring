package com.example.demo_spring_reactive.controller;


import com.example.demo_spring_reactive.dto.MessageDTO;
import com.example.demo_spring_reactive.model.Message;
import com.example.demo_spring_reactive.service.MessageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> get() {
        return messageService.getFlux();
    }

    @PostMapping
    public void post(@RequestBody MessageDTO messageDTO) {
        messageService.sendMessage(messageDTO.getSender(), messageDTO.getContent());
    }
}
