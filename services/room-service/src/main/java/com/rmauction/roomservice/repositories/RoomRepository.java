package com.rmauction.roomservice.repositories;

import com.rmauction.roomservice.entities.Room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ranajit Roy on 3/28/2023
 */

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByCreatorId(long creatorId);
}
