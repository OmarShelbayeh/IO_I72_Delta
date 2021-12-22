package com.example.IO.service;

import java.util.Optional;

import com.example.IO.model.User;
import com.example.IO.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findUserByEmail(email);

        user.orElseThrow(() -> new UsernameNotFoundException(email + " not found."));

        return user.map(UserDetailsImpl::new).get();
    }

}