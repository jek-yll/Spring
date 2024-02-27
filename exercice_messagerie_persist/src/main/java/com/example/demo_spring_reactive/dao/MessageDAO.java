package com.example.demo_spring_reactive.dao;

import com.example.demo_spring_reactive.dto.MessageDTO;
import com.example.demo_spring_reactive.model.Message;
import com.example.demo_spring_reactive.repository.MessageRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class MessageDAO {

    private final ConnectionFactory connectionFactory;
    private final MessageRepository messageRepository;
    private DatabaseClient databaseClient;

    public MessageDAO(ConnectionFactory connectionFactory, MessageRepository messageRepository) {
        this.connectionFactory = connectionFactory;
        this.messageRepository = messageRepository;
        databaseClient = DatabaseClient.create(connectionFactory);
        databaseClient.sql("CREATE TABLE IF NOT EXISTS message(" +
                "id bigint primary key auto_increment, " +
                "sender varchar(55), " +
                "content varchar(155), " +
                "message_Date_Time timestamp)")
                .then().doOnSuccess((Void) -> {
                    System.out.println("Création de table message OK");
                }).doOnError((Void) -> {
                    System.out.println("Erreur lors de la création de table message");
                }).subscribe();
    }

    public Flux<MessageDTO> getAll(){
        return messageRepository.findAll()
                .map(message ->  MessageDTO.builder()
                .content(message.getContent())
                .sender(message.getSender())
                .build());
    }

    public Mono<Void> post(MessageDTO messageDTO){
         return messageRepository.save(
                Message.builder()
                        .content(messageDTO.getContent())
                        .sender(messageDTO.getContent())
                        .messageDateTime(LocalDateTime.now())
                        .build()).then();
    }

}
