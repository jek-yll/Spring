package org.example.exo_session.service;

import org.example.exo_session.model.User;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    private User user;
    public LoginService() {
        this.user = User.builder()
                .id(1)
                .username("admin")
                .password("password")
                .build();
    }

    public User getUser(){
        return user;
    }
}
