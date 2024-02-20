package org.example.tp_blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp_blog.model.Post;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private UUID id;

    @NotNull
    @Pattern(regexp = "^[A-Za-z].{0,49}$", message = "Invalid field")
    private String author;

    @NotNull
    @Pattern(regexp = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$", message = "Invalid field")
    private String email;

    @NotNull
    @NotBlank
    private String content;

    private UUID postId;

}
