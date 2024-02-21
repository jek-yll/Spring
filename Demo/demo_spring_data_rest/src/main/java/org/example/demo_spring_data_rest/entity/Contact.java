package org.example.demo_spring_data_rest.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
}
