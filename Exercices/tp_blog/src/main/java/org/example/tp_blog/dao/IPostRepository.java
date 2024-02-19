package org.example.tp_blog.dao;

import org.example.tp_blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPostRepository extends JpaRepository<Post, UUID> {

    Post findByIdIs(UUID id);
}
