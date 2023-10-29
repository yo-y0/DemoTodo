package com.example.todoServer.controller;

import com.example.todoServer.entity.User;
import com.example.todoServer.exception.Exception;
import com.example.todoServer.repository.TodoRepository;
import com.example.todoServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping()
    public List<User> getUser() {
        return userRepository.findAll();

    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException());

    }
}