package com.example.IO.service;


import com.example.IO.model.User;
import com.example.IO.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;
/**
 * @author IO-I72-Delta
 * @version 1.0
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Autowired - inject collaborating beans into our bean
     * @param userRepository - UserRepository class object
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * The method looks for the user in the database and returns his object
     *
     * @param userId - user's ID
     * @return User class - the appropriate user class
     */
    public Optional<User> getUserById(Long userId){
        return userRepository.findUserByUserId(userId);
    }

    /**
     * The method looks for the user in the database and returns his object
     *
     * @param email - user's email
     * @return User class - the appropriate user class
     */
    public Optional<User> getUsersByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    /**
     * The method is used to register the user with the use of the database
     *
     * @param user - user data
     * @throws Exception - throw an exception if there is no user
     */
    public void register(User user) throws Exception {
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
        if(userRepository.findUserByEmail(user.getEmail()).isPresent()) throw new Exception();
        else userRepository.save(user);
    }

    /**
     * The function finds the user by email
     *
     * @param email - user email
     * @return User class - the appropriate user class
     */
    public User findUserByUserEmail(String email){
        return userRepository.findUserByEmail(email).isPresent() ? userRepository.findUserByEmail(email).get() : new User();
    }
}
