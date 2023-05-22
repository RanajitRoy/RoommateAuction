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
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;


    public Room getRoom(long roomId) {
        Optional<Room> or = roomRepository.findById(roomId);
        if(or.isEmpty()){
            throw new RoomNotFoundException();
        }
        return or.get();
    }

    public List<Room> getRoomByCreator(long creatorId) {
        List<Room> or = roomRepository.findByCreatorId(creatorId);
        return or;
    }
   
    public Room createRoom(String roomName, long userId) {
        Optional<User> uf = userRepository.findById(userId);
        if(uf.isPresent()) {
            User user = uf.get();
            Room newRoom = new Room();
            newRoom.setCreatorId(userId);
            newRoom.setRoomName(roomName);
            user.getRooms().add(newRoom);
            newRoom.getParticipators().add(user);
            return roomRepository.save(newRoom);
        }
        return null;
    }

    public Room addRoomParticipator(long roomId, long userId) {
        Optional<Room> rf = roomRepository.findById(roomId);
        Optional<User> uf = userRepository.findById(userId);
        if(rf.isPresent() && uf.isPresent()) {
            Room room = rf.get();
            User user = uf.get();
            user.getRooms().add(room);
            room.getParticipators().add(user);
            return roomRepository.save(room);
        }
        return null;
    }
}
