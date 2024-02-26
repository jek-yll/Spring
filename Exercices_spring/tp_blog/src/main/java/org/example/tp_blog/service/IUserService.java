package org.example.tp_blog.service;

import org.example.tp_blog.model.User;

import java.util.UUID;

public interface IUserService {

    User addUser (User user);
    User getUserById(UUID id);
}
