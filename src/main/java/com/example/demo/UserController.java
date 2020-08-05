package com.example.demo;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<UserResponse> getAllUser() {
        List<UserResponse> users = new ArrayList<>();
        users.add(new UserResponse(1, "User 1"));
        users.add(new UserResponse(2, "User 2"));
        users.add(new UserResponse(3, "User 3"));
        return users;
    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        return new UserResponse(id, "User " + id);
    }

}
