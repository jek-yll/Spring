package com.example.demo_validation.model;

import com.example.demo_validation.validation.MyValid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @NotBlank(message = "On a dis pas vide !!!")
    @NotNull
    @MyValid(value = "ti" ,message = "doit contenir ti svp")
    //@MyValid
    private String firstName;

    @NotBlank
    @NotNull
    @Size(min = 3, message = "3 lettres minimum")
    private String lastName;

    @Min(3)
    @Max(42)
    private Integer age;

}
