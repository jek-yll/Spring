package org.example.tp_blog.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.example.tp_blog.model.Comment;

import java.util.UUID;

public interface ICommentRepository  extends JpaRepository<Comment, UUID> {

}
