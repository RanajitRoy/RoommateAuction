package com.rmauction.roomservice.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ranajit Roy on 3/29/2023
 */

 @Entity
 @Data
//  @NoArgsConstructor
 @AllArgsConstructor
public class RoomParticipator {
    // @ManyToOne
    // private Room room;
    
    // @Nonnull
    // private long userId;
}
