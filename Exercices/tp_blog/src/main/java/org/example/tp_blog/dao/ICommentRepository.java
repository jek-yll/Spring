package org.example.tp_blog.dao;


import org.example.tp_blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ICommentRepository  extends JpaRepository<Comment, UUID> {
    Comment findByIdIs(UUID id);
    List<Comment> findAllByPost(UUID id);
}
