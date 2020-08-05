package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        userResponseList.add(new UserResponse(1, "User 1"));
        userResponseList.add(new UserResponse(2, "User 2"));
        userResponseList.add(new UserResponse(3, "User 3"));

        pagingResponse.setUserResponseList(userResponseList);
        return pagingResponse;
    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        return new UserResponse(id, "User " + id);
    }



}
