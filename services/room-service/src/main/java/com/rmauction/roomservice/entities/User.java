package com.rmauction.roomservice.entities;

import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    
    @Nonnull
    private String userName;

    @Nonnull
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "participators")
    private Set<Room> rooms;
}
