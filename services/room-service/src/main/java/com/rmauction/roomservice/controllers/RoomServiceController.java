package com.rmauction.roomservice.controllers;

import com.rmauction.roomservice.entities.Room;
import com.rmauction.roomservice.services.RoomService;
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
    public Page<Room> getRooms(@PathVariable int pageNo, @PathVariable int pageSize) {
        Page<Room> page = roomService.getRooms(pageNo, pageSize);
        return page;
    }

    @GetMapping(path="/{id}")
    public Room getRooms(@PathVariable long id) {
        return roomService.getRoomsById(id);
    }

    @GetMapping
    public Page<Room> getRooms() {
        Page<Room> page = roomService.getRooms();
        return page;
    }

    record RoomReq(String roomName){}

    @PostMapping
    public Room createRooms(@RequestBody RoomReq roomReq) {
        Room newRoom = new Room();
        newRoom.setRoomName(roomReq.roomName);
        return roomService.createRoom(newRoom);
    }
}
