package org.example.exo1_spring_data_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "candies_order")
public class CandiesOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "candiesOrder", cascade = CascadeType.ALL)
    private List<CandiesOrderLine> orderLines;
}
