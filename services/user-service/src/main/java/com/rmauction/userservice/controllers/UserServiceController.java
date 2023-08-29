package com.rmauction.userservice.controllers;

import com.rmauction.userservice.entities.User;
import com.rmauction.userservice.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ranajit Roy on 3/28/2023
 */

@RestController
@RequestMapping(path="/user")
public class UserServiceController {

    @Autowired
    private UserService userService;

    // getting a room by id
    @GetMapping(path="/{userId}")
    public User getUser(@PathVariable long userId) {
        User user = userService.getUser(userId);
        if(user != null)
            return user;
        throw new UserNotFoundException();
    }

    record UserReq(String userName){}

    // create a new room
    @PostMapping
    public User createUser(@RequestBody UserReq userReq) {
        User user = userService.createUser(userReq.userName);
        if(user != null)
            return user;
        throw new RuntimeException("User exists!");
    }
}
