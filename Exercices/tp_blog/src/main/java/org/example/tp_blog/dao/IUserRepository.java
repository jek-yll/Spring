package org.example.tp_blog.dao;

import org.example.tp_blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {

    User findByIdIs(UUID id);
    //Boolean existsByEmail(String email);
    User findUserByEmail(String email);
}
