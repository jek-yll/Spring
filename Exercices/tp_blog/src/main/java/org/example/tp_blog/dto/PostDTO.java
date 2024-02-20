package org.example.tp_blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp_blog.model.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private UUID id;
    @NotNull
    @Pattern(regexp = "^[A-Za-z].{0,49}$", message = "Invalid field")
    private String title;
    @NotNull
    @NotBlank(message = "Invalid field")
    private String description;
    @NotNull
    @NotBlank(message = "Invalid field")
    private String content;
    @NotNull
    @Pattern(regexp = "^[A-Za-z\\d\\s].{0,49}$", message = "Invalid field")
    private String author;
    private List<Comment> comments = new ArrayList<>();


}