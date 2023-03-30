package com.rmauction.roomservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ranajit Roy on 3/29/2023
 */

 @Entity
 @Data
 @NoArgsConstructor
 @AllArgsConstructor
public class User {
    @Id
    private long userId;
}
