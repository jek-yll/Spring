package org.example.tp_blog.service;

import org.example.tp_blog.dao.IUserRepository;
import org.example.tp_blog.exception.EmailExistException;
import org.example.tp_blog.model.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImplA implements IUserService {

    private final IUserRepository userRepository;

    public UserServiceImplA(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //TODO: Créer exception emailExistException
    @Override
    public User addUser(User user) throws EmailExistException {
        if (userRepository.findUserByEmail(user.getEmail()) != null){
            System.out.println("erreur");
            return null;
        } else {
            System.out.println("ok");
            return userRepository.save(user);
        }
    }

    @Override
    public User getUserById(UUID id) {
        return null;
    }
}
