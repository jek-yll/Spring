package com.example.demo_r2dbc.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Data
@Builder
public class Address {
    @Id
    private Long id;
    private String fullAddress;
    private int personId;
    @Transient
    private Person person;

}
