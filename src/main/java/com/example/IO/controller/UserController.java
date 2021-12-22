package com.example.IO.controller;

import com.example.IO.model.User;
import com.example.IO.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/register")
    public void register(@RequestBody User user) throws Exception {
        userService.register(user);
    }

    @GetMapping(path = "/findUserByUserEmail")
    public User findUserByUserEmail(@RequestParam String email){
        return userService.findUserByUserEmail(email);
    }
}
