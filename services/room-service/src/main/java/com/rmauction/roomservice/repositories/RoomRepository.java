package com.rmauction.roomservice.repositories;

import com.rmauction.roomservice.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ranajit Roy on 3/28/2023
 */

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
