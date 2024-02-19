package org.example.tp_blog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
