package com.rmauction.userservice.services;

import com.rmauction.userservice.controllers.UserNotFoundException;
//import com.rmauction.roomservice.entities.RoomParticipator;
import com.rmauction.userservice.entities.User;
import com.rmauction.userservice.repositories.UserRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ranajit Roy on 3/28/2023
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUser(long userId) {
        Optional<User> ou = userRepository.findById(userId);
        if(ou.isEmpty()){
            throw new UserNotFoundException();
        }
        return ou.get();
    }

    
    public User createUser(String userName) {
        boolean exists = userRepository.existsByUserName(userName);
        if(!exists) {
            User user = new User();
            user.setUserName(userName);
            return userRepository.save(user);
        }
        return null;
    }
}
