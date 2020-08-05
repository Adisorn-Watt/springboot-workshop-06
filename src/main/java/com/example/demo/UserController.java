package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

//    @GetMapping("/users")
//    public List<UserResponse> getAllUser() {
//        List<UserResponse> users = new ArrayList<>();
//        users.add(new UserResponse(1, "User 1"));
//        users.add(new UserResponse(2, "User 2"));
//        users.add(new UserResponse(3, "User 3"));
//        return users;
//    }
    // Test req param
    @GetMapping("/users")
    public String getPage (@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "10")int itemPerPage) {
        return "Page: " +page+ ", itemPerPage: " +itemPerPage;
    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        return new UserResponse(id, "User " + id);
    }

}
