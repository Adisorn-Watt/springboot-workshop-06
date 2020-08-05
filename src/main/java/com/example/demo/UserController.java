package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public UserResponse createNewUser(@RequestBody NewUserRequest request) {
        // Validate input
        // Create new user into database =>
        User user = new User();
        user.setName(request.getName());
        user.setAge(request.getAge());
        user = userRepository.save(user);
        return new UserResponse(user.getId(), user.getName() + user.getAge());
    }

    // Test req param
    @GetMapping("/users")
    public PagingResponse getAllUser (
            @RequestParam(required = false, defaultValue = "1")int page,
            @RequestParam(name = "item_per_page", required = false, defaultValue = "10")int itemPerPage) {
        PagingResponse pagingResponse = new PagingResponse(page, itemPerPage);
        List<UserResponse> userResponseList = new ArrayList<>();

        Iterable<User> users = userRepository.findAll();
        for (User user: users) {
            userResponseList.add(new UserResponse(user.getId(), user.getName()));
        }

        pagingResponse.setUserResponseList(userResponseList);
        return pagingResponse;
    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        return new UserResponse(user.get().getId(), user.get().getName());
    }



}
