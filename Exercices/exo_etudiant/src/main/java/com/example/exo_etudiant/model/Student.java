package com.example.exo_etudiant.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private UUID id;

    //@NotBlank(message = "Invalid field")
    @NotNull(message = "Invalid field")
    @Pattern(regexp = "^[A-Za-z].{0,49}$", message = "Invalid field")
    private String firstName;

    //@NotBlank(message = "Invalid field")
    @NotNull(message = "Invalid field")
    @Pattern(regexp = "^[A-Za-z].{0,49}$", message = "Invalid field")
    private String lastName;

    @NotNull(message = "Invalid field")
    @Min(value = 16, message = "Age must be at least 16")
    private Integer age;

    //@NotBlank(message = "Invalid field")
    @NotNull(message = "Invalid field")
    @Pattern(regexp = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$", message = "Invalid field")
    private String email;
}
