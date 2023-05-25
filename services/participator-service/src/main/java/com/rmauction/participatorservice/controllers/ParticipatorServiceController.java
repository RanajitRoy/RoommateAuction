package com.rmauction.participatorservice.controllers;

import com.rmauction.participatorservice.entities.Room;
import com.rmauction.participatorservice.entities.User;
import com.rmauction.participatorservice.services.ParticipatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ranajit Roy on 5/24/2023
 */
@RestController
@RequestMapping(path="/participator")
public class ParticipatorServiceController {
    @Autowired
    private ParticipatorService participatorService;

    @GetMapping(path="/room/{roomId}")
    public List<User> getRoomParticipators(@PathVariable long roomId) {
        return participatorService.getRoomParticipators(roomId);
    }

    @GetMapping(path="/user/{userId}")
    public List<Room> getUserParticipators(@PathVariable long userId) {
        return participatorService.getUserParticipators(userId);
    }

    @PutMapping(path="/add")
    public List<User> addParticipator(@RequestParam(required = true) long roomId, @RequestParam(required = true) long userId) {
        return participatorService.addRoomParticipator(roomId, userId);
    }
}
