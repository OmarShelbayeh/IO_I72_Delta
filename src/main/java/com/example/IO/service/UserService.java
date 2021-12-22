package com.example.IO.service;


import com.example.IO.model.User;
import com.example.IO.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Long userId){
        return userRepository.findUserByUserId(userId);
    }

    public Optional<User> getUsersByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

}
