package com.rmauction.roomservice.controllers;

import com.rmauction.roomservice.entities.Room;
import com.rmauction.roomservice.entities.User;
import com.rmauction.roomservice.services.RoomService;
import com.rmauction.roomservice.services.UserService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ranajit Roy on 3/28/2023
 */

@RestController
@RequestMapping(path="/room")
public class RoomServiceController {

    @Autowired
    private RoomService roomService;

    // getting a room by id
    @GetMapping(path="/{roomId}")
    public Room getRoom(@PathVariable long roomId) {
        Room room = roomService.getRoom(roomId);
        if(room != null)
            return room;
        throw new RoomNotFoundException();
    }

//    @GetMapping(path="/{roomId}/participators")
//    public List<User> getRoomParticipators(@PathVariable long roomId) {
//        Room room = roomService.getRoom(roomId);
//        if(room != null)
//            return room.getParticipators();
//        throw new RoomNotFoundException();
//    }

    // getting rooms created by a user.
    @GetMapping
    public List<Room> getRoomByCreator(@RequestParam(required = true) long creatorId) {
        List<Room> rooms = roomService.getRoomByCreator(creatorId);
        return rooms;
    }

    record RoomReq(String roomName){}

    // create a new room
    @PostMapping
    public Room createRoom(@RequestBody RoomReq roomReq, @RequestParam(required = true) long creatorId) {
        Room room = roomService.createRoom(roomReq.roomName, creatorId);
        if(room != null)
            return room;
        throw new UserNotFoundException();
    }

    // create a new room
    @PutMapping(path="/{roomId}/add/{creatorId}")
    public Room addParticipator(@PathVariable long roomId, @PathVariable long creatorId) {
        Room room = roomService.addRoomParticipator(roomId, creatorId);
        if(room != null)
            return room;
        throw new UserNotFoundException();
    }
}
