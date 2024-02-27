package com.example.demo_spring_reactive.controller;


import com.example.demo_spring_reactive.dao.MessageDAO;
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
    private final MessageDAO messageDAO;

    public MessageController(MessageService messageService, MessageDAO messageDAO) {
        this.messageService = messageService;
        this.messageDAO = messageDAO;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> get() {
        return messageService.getFlux();
    }

    @PostMapping
    public void post(@RequestBody MessageDTO messageDTO) {
        messageService.sendMessage(messageDTO.getSender(), messageDTO.getContent());
    }

    @PostMapping("/bdd")
    public void postBdd(@RequestBody MessageDTO messageDTO) {
        messageService.sendMessageBdd(messageDTO.getSender(), messageDTO.getContent());
        //messageDAO.post(messageDTO);

    }

    @GetMapping("/bdd")
    public Flux<MessageDTO> getAll(){
        return messageService.getFluxBdd();
        //return messageDAO.getAll();
    }


}
