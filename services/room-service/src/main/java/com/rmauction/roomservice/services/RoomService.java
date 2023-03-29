package com.rmauction.roomservice.services;

import com.rmauction.roomservice.entities.Room;
import com.rmauction.roomservice.repositories.RoomRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Ranajit Roy on 3/28/2023
 */

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Page<Room> getRooms() {
        return getRooms(0, 10);
    }

    public Page<Room> getRooms(int pageNo, int pageSize) {
        return roomRepository.findAll(PageRequest.of(pageNo,pageSize));
    }

    public Optional<Room> getRoomsById(long id) {
        return roomRepository.findById(id);
    }

    public Room createRoom(Room newRoom) {
        return roomRepository.save(newRoom);
    }

}
