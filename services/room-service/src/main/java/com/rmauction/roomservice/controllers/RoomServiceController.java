package com.rmauction.roomservice.controllers;

import com.rmauction.roomservice.entities.Room;
import com.rmauction.roomservice.services.RoomService;

import java.util.Optional;

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

    @GetMapping(path="/{pageNo}/{pageSize}")
    public Page<Room> getRooms(@PathVariable int pageNo, @PathVariable int pageSize, @RequestParam(required = true) long userId) {
        Optional<Page<Room>> page = roomService.getRooms(pageNo, pageSize, userId);
        if(page.isPresent())
            return page.get();
        throw new UserNotFoundException();
    }

    @GetMapping(path="/{id}")
    public Room getRooms(@PathVariable long id, @RequestParam(required = true) long userId) {
        Optional<Room> room = roomService.getRoomById(id, userId);
        if(room.isPresent()) {
            return room.get();
        }
        else throw new RoomNotFoundException();
    }

    @GetMapping
    public Page<Room> getRooms(@RequestParam(required = true) long userId) {
        Optional<Page<Room>> page = roomService.getRooms(userId);
        if(page.isPresent())
            return page.get();
        throw new UserNotFoundException();
    }

    record RoomReq(String roomName){}

    @PostMapping
    public Room createRooms(@RequestBody RoomReq roomReq, @RequestParam(required = true) long userId) {
        Optional<Room> room = roomService.createRoom(roomReq.roomName, userId);
        if(room.isPresent())
            return room.get();
        throw new UserNotFoundException();
    }
}
