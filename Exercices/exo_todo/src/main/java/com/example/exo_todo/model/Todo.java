package com.example.exo_todo.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    private String name;
    private String description;
    private Boolean done;

}
