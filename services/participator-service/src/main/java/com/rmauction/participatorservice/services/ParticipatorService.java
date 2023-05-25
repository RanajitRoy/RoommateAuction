package com.rmauction.participatorservice.services;

import com.rmauction.participatorservice.entities.Room;
import com.rmauction.participatorservice.entities.User;
import com.rmauction.participatorservice.repositories.RoomRepository;
import com.rmauction.participatorservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Ranajit Roy on 5/24/2023
 */

@Service
public class ParticipatorService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;


    public List<User> getRoomParticipators(long roomId) {
        Optional<Room> or = roomRepository.findById(roomId);
        if(or.isEmpty()){
            throw new RoomNotFoundException();
        }
        return or.get().getParticipators();
    }

    public List<Room> getUserParticipators(long userId) {
        Optional<User> or = userRepository.findById(userId);
        if(or.isEmpty()){
            throw new UserNotFoundException();
        }
        return or.get().getRooms();
    }

    public List<User> addRoomParticipator(long roomId, long userId) {
        Optional<Room> rf = roomRepository.findById(roomId);
        Optional<User> uf = userRepository.findById(userId);
        if (rf.isEmpty()) {
            throw new RoomNotFoundException();
        }
        if (uf.isEmpty()) {
            throw new UserNotFoundException();
        }
        Room room = rf.get();
        User user = uf.get();
        if(room.getParticipators().stream().anyMatch(x -> x.getUserId() == user.getUserId()))
        {
            return room.getParticipators();
        }
        user.getRooms().add(room);
        room.getParticipators().add(user);
        roomRepository.save(room);

        return room.getParticipators();
    }
}
