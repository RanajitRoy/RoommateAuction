package com.rmauction.roomservice.services;

import com.rmauction.roomservice.controllers.RoomNotFoundException;
import com.rmauction.roomservice.controllers.UserNotFoundException;
import com.rmauction.roomservice.entities.Room;
import com.rmauction.roomservice.entities.RoomParticipator;
import com.rmauction.roomservice.entities.User;
import com.rmauction.roomservice.repositories.RoomRepository;
import com.rmauction.roomservice.repositories.UserRepository;

import jakarta.persistence.criteria.Join;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
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
