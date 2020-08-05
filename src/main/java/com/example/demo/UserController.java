package com.example.demo;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users")
    public UserResponse[] getAllUser() {
        UserResponse[] u = new UserResponse[2];
        u[0] = new UserResponse(1, "User 1");
        u[1] = new UserResponse(2, "User 2");
        return u;
    }

}
