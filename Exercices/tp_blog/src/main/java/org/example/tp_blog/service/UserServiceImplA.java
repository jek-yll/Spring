package org.example.tp_blog.service;

import org.example.tp_blog.dao.IUserRepository;
import org.example.tp_blog.model.User;

import java.util.UUID;

public class UserServiceImplA implements IUserService {

    private final IUserRepository userRepository;

    public UserServiceImplA(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //TODO: Créer exception emailExistException
    @Override
    public User addUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())){
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @Override
    public User getUserById(UUID id) {
        return null;
    }
}
