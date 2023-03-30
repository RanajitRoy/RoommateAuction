package com.rmauction.roomservice.services;

import com.rmauction.roomservice.entities.Room;
import com.rmauction.roomservice.entities.RoomParticipator;
import com.rmauction.roomservice.entities.User;
import com.rmauction.roomservice.repositories.RoomRepository;
import com.rmauction.roomservice.repositories.UserRepository;

import jakarta.persistence.criteria.Join;

import java.util.List;
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

    public Page<Room> getRooms(long userId) {
        return getRooms(0, 10, userId);
    }

    public Page<Room> getRooms(int pageNo, int pageSize, long userId) {
        Specification<Room> spec = hasParticipator(userId);
        return roomRepository.findAll(spec., PageRequest.of(pageNo,pageSize));
    }

    public Optional<Room> getRoomsById(long id, long userId) {
        Optional<User> uf = userRepository.findById(userId);
        if(uf.isPresent()) {
            Optional<Room> opt = roomRepository.findById(id);
            if(opt.isPresent() && opt.get().getCreatorId() == userId) {
                return opt;
            }
            else return Optional.empty();
        }
        return Optional.empty();
    }

    public Optional<Room> createRoom(String roomName, long userId) {
        Optional<User> uf = userRepository.findById(userId);
        if(uf.isPresent()) {
            Room newRoom = new Room();
            newRoom.setCreatorId(userId);
            newRoom.setRoomName(roomName);
            newRoom.setParticipators(List.of(new RoomParticipator(newRoom, userId)));
            return Optional.of(roomRepository.save(newRoom));
        }
        return Optional.empty();
    }

    public Optional<Room> addRoomParticipator(long roomId, long userId, long creatorId) {
        Optional<User> uf = userRepository.findById(userId);
        if(uf.isPresent()) {
            Optional<Room> room = getRoomsById(roomId, creatorId);
            Room newRoom = new Room();
            newRoom.setCreatorId(userId);
            newRoom.setRoomName(roomName);
            newRoom.setParticipators(List.of(new RoomParticipator(newRoom, userId)));
            return Optional.of(roomRepository.save(newRoom));
        }
        return Optional.empty();
    }

    public static Specification<Room> hasParticipator(long userId) {
        return (root, query, criteriaBuilder) -> {
            Join<Room, RoomParticipator> roomParts = root.join("participators");
            return criteriaBuilder.equal(roomParts.get("userId"), userId);
        };
    }
}
