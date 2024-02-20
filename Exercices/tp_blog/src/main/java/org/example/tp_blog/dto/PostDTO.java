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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
