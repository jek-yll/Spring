package org.example.exo1_spring_data_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Candy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String magicEffect;
    private Long Stock;
    private Double price;
    @OneToMany
    private List<CustomerReview> customerReviews;
}
