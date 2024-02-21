package org.example.exo1_spring_data_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CustomerReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String review;
    private Integer rating;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "candy_id")
    private Candy candy;
}
