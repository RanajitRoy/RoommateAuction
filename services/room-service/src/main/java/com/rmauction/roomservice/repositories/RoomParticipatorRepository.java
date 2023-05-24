
package com.rmauction.roomservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmauction.roomservice.entities.User;

/**
 * @author Ranajit Roy on 3/29/2023
 */
@Repository
public interface RoomParticipatorRepository extends JpaRepository<User, Long> {
    
}
