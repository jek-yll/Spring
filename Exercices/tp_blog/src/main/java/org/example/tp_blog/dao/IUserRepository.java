package org.example.tp_blog.dao;

import org.example.tp_blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {

    User findByIdIs(UUID id);
    Boolean existsByEmail(String email);
}
