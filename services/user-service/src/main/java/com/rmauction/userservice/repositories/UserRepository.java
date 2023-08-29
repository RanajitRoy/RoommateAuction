package com.rmauction.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmauction.userservice.entities.User;

/**
 * @author Ranajit Roy on 3/29/2023
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUserName(String userName);
}
