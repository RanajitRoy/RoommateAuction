package com.rmauction.roomservice.entities;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Ranajit Roy on 3/28/2023
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Room {

    @Id
    @SequenceGenerator(name = "roomIdSequence", sequenceName = "roomIdSequence", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomIdSequence")
    private long roomId;

    @Nonnull
    private String roomName;

    @Nonnull
    private long creatorId;

    @Nonnull
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name = "ROOM_USER",
        joinColumns = @JoinColumn(
                name = "roomId",
                referencedColumnName = "roomId"
        ),
        inverseJoinColumns = @JoinColumn(
                name = "userId",
                referencedColumnName = "userId"
        )
    )
    private List<User> participators = new LinkedList<>();
}
