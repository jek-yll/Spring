package org.example.exo1.controller;

import org.example.exo1.model.Message;
import org.example.exo1.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/message")
public class ChatController {

    public final MessageService messageService;

    public ChatController(MessageService messageService){
        this.messageService = messageService;
    }

//    @GetMapping("send/{message}")
//    public ResponseEntity<Message> addMessage(@PathVariable("message")Message message){
//        this.messageService.sendMessage(message);
//        // return ResponseEntity.ok("message envoyé à " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm")));
//        return ResponseEntity.ok(message);
//    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> get(){
        return messageService.getMessage();
    }

    @PostMapping(value = "send", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postMessage(@RequestBody Message message){
        messageService.sendMessage(message);
        return new ResponseEntity<>("message envoyé à " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm")), HttpStatus.ACCEPTED);
    }

}
