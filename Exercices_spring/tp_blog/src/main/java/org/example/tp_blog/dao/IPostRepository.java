package org.example.tp_blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.tp_blog.model.Post;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface IPostRepository extends JpaRepository<Post, UUID> {
    Post findByIdIs(UUID id);
}
