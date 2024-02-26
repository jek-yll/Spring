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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }
}
