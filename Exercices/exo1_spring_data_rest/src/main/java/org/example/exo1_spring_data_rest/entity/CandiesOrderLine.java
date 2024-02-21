package org.example.exo1_spring_data_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CandiesOrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "candy_id")
    private Candy candy;
    @ManyToOne
    @JoinColumn(name = "candies_order_id")
    private CandiesOrder candiesOrder;
}
