package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private UserService userService;

    @GetMapping("/get/{userId}")
    public User getUserById(@PathVariable("userId") int userId) {
        User output = userRepository.findByUserID(userId);

        return userRepository.findByUserID(userId);
    }
}